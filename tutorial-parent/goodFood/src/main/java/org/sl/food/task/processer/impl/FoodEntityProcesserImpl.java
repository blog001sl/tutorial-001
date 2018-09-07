package org.sl.food.task.processer.impl;

import java.io.IOException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.sl.food.entity.FoodEntity;
import org.sl.food.task.processer.IProcesser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FoodEntityProcesserImpl implements IProcesser<FoodEntity> {

	@Override
	public List<FoodEntity> processerDocument(Document doc) {
		Elements el = doc.select("#listtyle1_list .listtyle1 a.big");
		logger.debug("{}", el);
		List<FoodEntity> foodList = new LinkedList<>();
		for (Element e : el) {
			FoodEntity food = new FoodEntity();
			food.setUpdateTime(new Date());
			food.setName(e.attr("title"));
			food.setDetailsSite(e.attr("href"));
			food.setPicture(e.select("img").attr("src"));
			String tmp = e.select(".c2 .li2").text();
			String[] strArr = tmp.split("/");
			food.setTasteType(strArr[1].trim());

			Matcher m = idPattern.matcher(food.getDetailsSite());
			if (m.find()) {
				tmp = m.group();
				food.setId(tmp.substring(1, tmp.length() - 5));
			} else {
				food.setId(new Date().toString());
			}

			getMore(food);

			foodList.add(food);
		}

		return foodList;
	}

	private void getMore(FoodEntity food) {
		try {
			Document doc = Jsoup.connect(food.getDetailsSite()).get();
			Element difficult = doc.select(".info2 .w270 .processing").get(0);
			String dclass = difficult.attr("class");
			Matcher matcher = difficultPattern.matcher(dclass);
			matcher.find();
			String tmp = matcher.group();
			tmp = tmp.substring("processing_nd".length());
			food.setDiffculteLevel(Integer.parseInt(tmp));
			
			tmp = doc.select("#tongji_author").get(0).attr("href");
			matcher = authortPattern.matcher(tmp);
			matcher.find();
			tmp = matcher.group();
			tmp = tmp.substring(3);
			food.setAuther(tmp);
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		}

	}
	
	public long[] getFavorateById(String id) throws ClientProtocolException, IOException{
		String s = String.format("http://click.meishij.net/pl/click.php?from_search=0&classid=1&id=%s&addclick=1", id);
		HttpGet get = new HttpGet(s);
		get.setHeader("Accept-Encoding", "gzip, deflate, br");
		get.setHeader("Accept-Language", "zh-CN,zh;q=0.9,en;q=0.8");
		get.setHeader("Cache-Control", "no-cache");
		get.setHeader("Connection", "keep-alive");
		get.setHeader("Host", "click.meishij.net");
		get.setHeader("Pragma", "no-cache");
		get.setHeader("Referer", "https://www.meishij.net/zuofa/taiwanluroukuaishouban.html");
		get.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.81 Safari/537.36");
		
		HttpClient client = HttpClientBuilder.create().build();
		HttpResponse resposne = client.execute(get);
		String content = EntityUtils.toString(resposne.getEntity());
		
		String[] d = content.split("window.document.getElementById");

		String clicknum = d[1].split("=")[1];
		clicknum = clicknum.substring(0, clicknum.length() -1);
		long clickValue = Long.parseLong(clicknum);
		
		clicknum = d[2].split("=")[1];
		clicknum = clicknum.substring(2, clicknum.length() - 3);
		long favValue = Long.parseLong(clicknum);
		
		return new long[]{clickValue, favValue};
	}
	
	

	private static final Pattern idPattern = Pattern.compile("/\\w+.html");
	private static final Pattern difficultPattern = Pattern.compile("processing_nd\\d+");
	private static final Pattern authortPattern = Pattern.compile("id=\\w+$");
	private static final Logger logger = LoggerFactory.getLogger(FoodEntityProcesserImpl.class);
}

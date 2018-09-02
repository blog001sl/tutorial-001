package org.sl.food.task.processer.impl;

import java.io.IOException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

	private static final Pattern idPattern = Pattern.compile("/\\w+.html");
	private static final Pattern difficultPattern = Pattern.compile("processing_nd\\d+");
	private static final Pattern authortPattern = Pattern.compile("id=\\w+$");
	private static final Logger logger = LoggerFactory.getLogger(FoodEntityProcesserImpl.class);
}

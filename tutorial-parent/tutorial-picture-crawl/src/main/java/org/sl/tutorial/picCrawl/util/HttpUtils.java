package org.sl.tutorial.picCrawl.util;

import java.io.IOException;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpUtils {

	public static Document readToDocument(String url) {
		CloseableHttpClient client = HttpClientBuilder.create().build();

		HttpPost post = new HttpPost(url);

		try {
			CloseableHttpResponse response = client.execute(post);
			String content = EntityUtils.toString(response.getEntity());
			return Jsoup.parse(content);
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		} finally {
			try {
				client.close();
			} catch (IOException e) {
				logger.error(e.getMessage(), e);
			}
		}

		return null;
	}

	public static Elements findElements(Document doc, String selector) {
		Elements result = doc.select(selector);
		return result;
	}

	private static final Logger logger = LoggerFactory.getLogger(HttpUtils.class);
}

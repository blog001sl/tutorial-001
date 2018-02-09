package org.sl.tutorial.picCrawl;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Test {

	@org.junit.Test
	public void test() {
		String html = "<html><head><title>开源中国社区</title></head>" + "<body><p id='test'>这里是jsoup 项目的相关文章</p></body></html>";
		Document doc = Jsoup.parse(html);
		Elements el = doc.select("#test");
		logger.info("{}", el);

	}

	private static final Logger logger = LoggerFactory.getLogger(Test.class);
}

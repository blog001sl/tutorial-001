package org.sl.tutorial.picCrawl;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.sl.tutorial.picCrawl.core.DefaultProcesserImpl;
import org.sl.tutorial.picCrawl.core.IProcesser;
import org.sl.tutorial.picCrawl.util.HttpUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

@EnableAutoConfiguration
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

		Document doc = HttpUtils.readToDocument("http://www.meishij.net/zuofa/ganzhematitiantang_1.html");
//		Document doc = HttpUtils.readToDocument("http://www.baidu.com");
		Elements eList = HttpUtils.findElements(doc, ".cp_headerimg_w img");
		IProcesser processer = new DefaultProcesserImpl();
		processer.processElements(eList);
	}
}

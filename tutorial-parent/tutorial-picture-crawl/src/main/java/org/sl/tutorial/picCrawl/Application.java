package org.sl.tutorial.picCrawl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@EnableAutoConfiguration
@Configuration
@ComponentScan
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

//		Document doc = HttpUtils.readToDocument("http://www.meishij.net/zuofa/ganzhematitiantang_1.html");
//		Elements eList = HttpUtils.findElements(doc, ".cp_headerimg_w img");
//		IProcesser processer = new DefaultProcesserImpl();
//		processer.processElements(eList);
	}
}

package org.sl.food.task;

import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.sl.food.entity.FoodEntity;
import org.sl.food.mapper.FoodEntityMapper;
import org.sl.food.task.processer.IProcesser;
import org.sl.food.task.processer.impl.FoodEntityProcesserImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class FoodCrawlTask {

	@Value("${meishijie.website}")
	private String startWebSite;
	@Autowired
	private FoodEntityMapper foodMapper;
	
	@Scheduled(cron = "0/5 * *  * * ?")
	public void foodCrawl() {
		try {
			logger.info("starting......");
			// 1. get food link
			logger.info("getting link {}.", this.startWebSite);
			Document doc = Jsoup.connect(startWebSite).get();
			logger.debug("{}", doc);
			// 2. get food data
			IProcesser<FoodEntity> processer = new FoodEntityProcesserImpl();
			List<FoodEntity> foodList = processer.processerDocument(doc);
			// 3. parse data
			
			// 4. save food 
			for(FoodEntity food : foodList){
				FoodEntity t = foodMapper.selectByPrimaryKey(food.getId());
				if(null == t){
					foodMapper.insert(food);
				} else {
					foodMapper.updateByPrimaryKey(food);
				}
			}
		} catch(Exception e){
			logger.error(e.getMessage(), e);
		}
	}
	
	

	private static final Logger logger = LoggerFactory.getLogger(FoodCrawlTask.class);
}

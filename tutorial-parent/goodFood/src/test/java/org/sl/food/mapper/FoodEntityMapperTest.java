package org.sl.food.mapper;

import java.io.IOException;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.sl.food.entity.FoodEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/spring/spring-application.xml", "classpath*:/spring/spring-mvc.xml" })
public class FoodEntityMapperTest {

	@Autowired
	private FoodEntityMapper foodMapper;

	@Test
	public void testInsert() throws InterruptedException, IOException {
		FoodEntity food = new FoodEntity();
		long ra = new Date().getTime();
		food.setId(String.format("id-%d", ra));
		food.setName(String.format("name-%d", ra));
		foodMapper.insert(food);
		
		System.in.read();
	}

}

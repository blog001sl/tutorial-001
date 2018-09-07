package org.sl.food.mapper;

import java.io.IOException;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.http.client.ClientProtocolException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.sl.food.entity.FoodEntity;
import org.sl.food.task.processer.impl.FoodEntityProcesserImpl;
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

	@Test
	public void testGetFavoriate() throws ClientProtocolException, IOException{
		FoodEntityProcesserImpl impl = new FoodEntityProcesserImpl();
		long[] v = impl.getFavorateById("1878699");
		System.out.println(String.format("%d, %d", v[0], v[1]));
	}
	
	@Test
	public void testRegx(){
		Pattern p = Pattern.compile("innerHTML=.*;");
		Matcher m = p.matcher("window.document.getElementById('viewclicknum').innerHTML=45184;window.document.getElementById('f_num').innerHTML='(3336)';");
		
		while(m.find()){
			System.out.println(m.group());
		}
	}
}

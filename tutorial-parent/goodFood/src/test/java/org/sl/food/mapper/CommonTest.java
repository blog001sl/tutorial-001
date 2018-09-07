package org.sl.food.mapper;

import org.junit.Test;

public class CommonTest {

	@Test
	public void testSplit(){
		String s = "window.document.getElementById('viewclicknum').innerHTML=45184;window.document.getElementById('f_num').innerHTML='(3336)';";
		
		String[] d = s.split("window.document.getElementById");

		String clicknum = d[1].split("=")[1];
		clicknum = clicknum.substring(0, clicknum.length() -1);
		
		System.out.println(clicknum);
		
		clicknum = d[2].split("=")[1];
		clicknum = clicknum.substring(2, clicknum.length() - 3);
		System.out.println(clicknum);
		
	}
}

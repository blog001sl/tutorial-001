package org.sl.tutorial.picCrawl.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("imageview")
public class ImageViewController {

	@RequestMapping(params = "demo")
	@ResponseBody
	public String demo() {
		return "test";
	}
	
	@RequestMapping(params = "view")
	public void view(HttpServletRequest req, HttpServletResponse res) {
		try {
			res.setHeader("Content-Type","image/jpeg");
			
			File file = new File("C:/tmp/s3544412_150928552440486.jpg");
			FileInputStream hFile = new FileInputStream(file);
			//得到文件大小
			int i=hFile.available();
			byte data[]=new byte[i];
			//读数据
			hFile.read(data);
			OutputStream toClient=res.getOutputStream();
			toClient.write(data);
			hFile.close();
			toClient.flush();
			toClient.close();
			res.flushBuffer();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

package org.sl.tutorial.web.sample.controller;

import java.util.List;

import org.sl.tutorial.web.sample.entity.ImageEntity;
import org.sl.tutorial.web.sample.service.IImageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("image")
public class ImageController {

	@Autowired
	private IImageService imageService;

	@RequestMapping("list")
	@ResponseBody
	public List<ImageEntity> getImageList() {
		logger.info("enter list");
		return this.imageService.getAllImage();
	}

	private static final Logger logger = LoggerFactory.getLogger(ImageController.class);
}

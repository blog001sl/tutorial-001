package org.sl.tutorial.picCrawl.service.impl;

import java.util.List;

import javax.annotation.PostConstruct;

import org.sl.tutorial.picCrawl.entity.ImageDataEntity;
import org.sl.tutorial.picCrawl.service.IImageViewService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

@Service
public class ImageViewServiceImpl implements IImageViewService {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<ImageDataEntity> getAllImageList() {

		RowMapper<ImageDataEntity> mapper = new BeanPropertyRowMapper<ImageDataEntity>(ImageDataEntity.class);
		return jdbcTemplate.query("select * from t_image_data", mapper);

	}

	@PostConstruct
	public void init() {

		List<ImageDataEntity> data = this.getAllImageList();
		logger.info("data is {}.", data);
	}

	private static final Logger logger = LoggerFactory.getLogger(ImageViewServiceImpl.class);
}

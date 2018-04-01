package org.sl.tutorial.web.sample.service.impl;

import java.util.List;

import org.sl.tutorial.web.sample.entity.ImageEntity;
import org.sl.tutorial.web.sample.service.IImageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class ImageServiceImpl implements IImageService {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<ImageEntity> getAllImage() {

		return jdbcTemplate.query("select * from t_image_data",
				new BeanPropertyRowMapper<ImageEntity>(ImageEntity.class));
	}

	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(ImageServiceImpl.class);
}

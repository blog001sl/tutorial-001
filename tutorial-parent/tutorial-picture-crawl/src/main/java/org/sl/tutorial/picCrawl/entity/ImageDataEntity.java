package org.sl.tutorial.picCrawl.entity;

import java.sql.Timestamp;

public class ImageDataEntity {

	private Integer id;
	private String name;
	private String path;
	private Timestamp createDate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return "ImageDataEntity [id=" + id + ", name=" + name + ", path=" + path + ", createDate=" + createDate + "]";
	}

}

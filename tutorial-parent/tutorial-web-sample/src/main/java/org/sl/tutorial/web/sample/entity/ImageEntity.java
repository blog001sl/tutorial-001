package org.sl.tutorial.web.sample.entity;

import java.io.Serializable;
import java.util.Date;

public class ImageEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2370944169142183436L;

	private String id;

	private String name;

	private String path;

	private String content;

	private Date createDate;

	public ImageEntity() {
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return "ImageEntity [id=" + id + ", name=" + name + ", path=" + path + ", content=" + content + ", createDate="
				+ createDate + "]";
	}

}

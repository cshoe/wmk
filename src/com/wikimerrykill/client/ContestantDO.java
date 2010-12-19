package com.wikimerrykill.client;

public class ContestantDO {
	private String name;
	private String pageUrl;
	private String imageUrl;
	
	public ContestantDO(String name, String pageUrl, String imageUrl) {
		this.name = name;
		this.pageUrl = pageUrl;
		this.imageUrl = imageUrl;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPageUrl() {
		return pageUrl;
	}
	public void setPageUrl(String pageUrl) {
		this.pageUrl = pageUrl;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
}

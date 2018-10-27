package com.news.domain;

public class Newsinfo {

	public String title;
	public String link;
	public String pubDate;
	public String author;
	public String description;
	
	
	//public Newsinfo(){};
	
	
	public String getTitle() {
		return title;
	}
	@Override
	public String toString() {
		return "title=" + title + "--- link=" + link + "---- pubDate="
				+ pubDate + "--- author=" + author + "--- description="
				+ description;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getPubDate() {
		return pubDate;
	}
	public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}

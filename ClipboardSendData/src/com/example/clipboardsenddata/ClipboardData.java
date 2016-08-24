package com.example.clipboardsenddata;

import java.io.Serializable;

public class ClipboardData implements Serializable{
	private String title;
	private String content;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public ClipboardData(String title, String content) {
		super();
		this.title = title;
		this.content = content;
	}
	
	@Override
	public String toString() {
		return "标题："+this.title+"\t内容："+this.content;
	}
	

}

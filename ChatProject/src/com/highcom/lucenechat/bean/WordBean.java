package com.highcom.lucenechat.bean;

public class WordBean {
	private String key;
	private String text;
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	@Override
	public String toString() {
		return "WordBean [key=" + key + ", text=" + text + "]";
	}
	
}

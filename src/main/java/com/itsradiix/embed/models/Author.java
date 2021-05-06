package com.itsradiix.embed.models;

public class Author {

	private final String name;
	private final String url;
	private final String icon_url;

	public Author(String name, String url, String icon_url) {
		this.name = name;
		this.url = url;
		this.icon_url = icon_url;
	}

	public Author(String name, String value, boolean Url_or_iconUrl) {
		this.name = name;
		if(Url_or_iconUrl){
			this.url = value;
			this.icon_url = null;
		} else {
			this.icon_url = value;
			this.url = null;
		}
	}

	public Author(String name, String url) {
		this.name = name;
		this.url = url;
		this.icon_url = null;
	}

	public Author(String name) {
		this.name = name;
		this.url = null;
		this.icon_url = null;
	}

	public String getUrl() {
		return url;
	}

	public String getIcon_url() {
		return icon_url;
	}

	public String getName() {
		return name;
	}
}

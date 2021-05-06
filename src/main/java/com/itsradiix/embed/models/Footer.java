package com.itsradiix.embed.models;

public class Footer {

	private final String icon_url;
	private final String text;

	public Footer(String text, String icon_url) {
		this.icon_url = icon_url;
		this.text = text;
	}

	public Footer(String text) {
		this.icon_url = null;
		this.text = text;
	}

	public String getIcon_url() {
		return icon_url;
	}

	public String getText() {
		return text;
	}
}

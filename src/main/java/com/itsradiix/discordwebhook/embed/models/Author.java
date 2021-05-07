package com.itsradiix.discordwebhook.embed.models;

/**
 * The Author class represents an Author of an embedded message.
 * Make sure to read the wiki page on our GitHub to understand how to use this effectively.
 * https://github.com/ItsRadiiX/Definity-Webhooks/wiki
 */
public class Author {

	// Author variables
	private final String name;
	private final String url;
	private final String icon_url;

	/**
	 * This is the constructor to set the author of the embed.
	 * @param name This represents the author's name.
	 * @param url This represents the URL of the author.
	 * @param icon_url This represents the URL of the author icon.
	 */
	public Author(String name, String url, String icon_url) {
		this.name = name;
		this.url = url;
		this.icon_url = icon_url;
	}

	/**
	 * This is the constructor to set the author of the embed.
	 * @param name This represents the author's name.
	 * @param value This represents an URL -> boolean to set which one.
	 * @param url If true the URL will be the Author URL, if false it will be an Icon URL.
	 */
	public Author(String name, String value, boolean url) {
		this.name = name;
		if(url){
			this.url = value;
			this.icon_url = null;
		} else {
			this.icon_url = value;
			this.url = null;
		}
	}

	/**
	 * This is the constructor to set the author's name and the URL.
	 * @param name This sets the autor's name.
	 * @param url This sets the autor's URL
	 */
	public Author(String name, String url) {
		this.name = name;
		this.url = url;
		this.icon_url = null;
	}

	/**
	 * This is the constructor to only set the author's name.
	 * @param name This sets the author's name.
	 */
	public Author(String name) {
		this.name = name;
		this.url = null;
		this.icon_url = null;
	}

	/**
	 * @return String This returns the URL of the author.
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @return String This returns the Icon URL of the author
	 */
	public String getIcon_url() {
		return icon_url;
	}

	/**
	 * @return String This returns the name of the author.
	 */
	public String getName() {
		return name;
	}
}

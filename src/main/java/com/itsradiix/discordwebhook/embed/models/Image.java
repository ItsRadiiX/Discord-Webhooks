package com.itsradiix.discordwebhook.embed.models;

/**
 * The Image class represents an image in your embedded message.
 * Make sure to read the wiki page on our GitHub to understand how to use this effectively.
 * https://github.com/ItsRadiiX/Definity-Webhooks/wiki
 */
public class Image {

	// Image variables
	private final String url;

	/**
	 * This is the constructor to set the image via the provided URL.
	 * @param url This represents the URL of the provided image.
	 */
	public Image(String url) {
		this.url = url;
	}

	/**
	 * @return String Returns the URL of the image.
	 */
	public String getUrl() {
		return url;
	}
}

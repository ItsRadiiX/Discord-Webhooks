package com.itsradiix.discordwebhook.embed.models;

/**
 * The Thumbnail class represents a Thumbnail in your embedded message.
 * Make sure to read the wiki page on our GitHub to understand how to use this effectively.
 * https://github.com/ItsRadiiX/Definity-Webhooks/wiki
 */
public class Thumbnail {

	// Thumbnail variable
	private final String url;

	/**
	 * This is the constructor to set the thumbnail via the provided URL.
	 * @param url This represents the URL of the provided thumbnail.
	 */
	public Thumbnail(String url) {
		this.url = url;
	}

	/**
	 * @return String Returns the URL of the thumbnail.
	 */
	public String getUrl() {
		return url;
	}
}

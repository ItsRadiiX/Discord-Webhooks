package com.itsradiix.discordwebhook.embed.models;

/**
 * The Footer class represents the footer of an embedded message.
 * Make sure to read the wiki page on our GitHub to understand how to use this effectively.
 * https://github.com/ItsRadiiX/Definity-Webhooks/wiki
 */
public class Footer {

	// Footer variables
	private final String icon_url;
	private final String text;

	/**
	 * This is the constructor to set the footer text and the footer image via url.
	 * @param text This represents the content of the footer.
	 * @param icon_url This represents the URL of the footer icon.
	 */
	public Footer(String text, String icon_url) {
		this.icon_url = icon_url;
		this.text = text;
	}

	/**
	 * This is the constructor to set the footer text without icon.
	 * @param text This represents the content of the footer.
	 */
	public Footer(String text) {
		this.icon_url = null;
		this.text = text;
	}

	/**
	 * @return String This returns the URL of the footer iicon.
	 */
	public String getIcon_url() {
		return icon_url;
	}

	/**
	 * @return String This returns the footer text.
	 */
	public String getText() {
		return text;
	}
}

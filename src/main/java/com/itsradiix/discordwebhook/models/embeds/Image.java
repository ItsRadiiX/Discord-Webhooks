package com.itsradiix.discordwebhook.models.embeds;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Represents an image in an embedded message.
 * Images provide visual content within the embedded message.
 *
 * <p>Make sure to read the wiki page on our GitHub to understand how to use this effectively:
 * <a href="https://github.com/ItsRadiiX/Definity-Webhooks/wiki">Definity-Webhooks Wiki</a></p>
 *
 * @author ItsRadiiX
 * @version 2.0
 * @since 2024-05-19
 */
public class Image {

	/**
	 * The URL of the image.
	 */
	private final String url;

	/**
	 * The proxied URL of the image.
	 */
	private final String proxy_url;

	/**
	 * Constructs an Image with the specified URL and proxy URL.
	 *
	 * @param url The URL of the image.
	 * @param proxy_url The proxied URL of the image.
	 */
	public Image(@NotNull String url, @Nullable String proxy_url) {
		this.url = url;
		this.proxy_url = proxy_url;
	}

	/**
	 * Gets the URL of the image.
	 *
	 * @return The URL of the image.
	 */
	public String getURL() {
		return url;
	}

	/**
	 * Gets the proxied URL of the image.
	 *
	 * @return The proxied URL of the image.
	 */
	public String getProxyURL() {
		return proxy_url;
	}
}

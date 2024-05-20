package com.itsradiix.discordwebhook.models.embeds;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Represents a thumbnail in an embedded message.
 * Thumbnails provide a small preview of an image or video within the embedded message.
 *
 * <p>Make sure to read the wiki page on our GitHub to understand how to use this effectively:
 * <a href="https://github.com/ItsRadiiX/Definity-Webhooks/wiki">Definity-Webhooks Wiki</a></p>
 *
 * @author ItsRadiiX
 * @version 2.0
 * @since 2024-05-19
 */
public class Thumbnail {

	/**
	 * The URL of the thumbnail image.
	 */
	private final String url;

	/**
	 * The proxied URL of the thumbnail image.
	 */
	private final String proxy_url;

	/**
	 * Constructs a Thumbnail with the specified URL and proxy URL.
	 *
	 * @param url The URL of the thumbnail image.
	 * @param proxy_url The proxied URL of the thumbnail image.
	 */
	public Thumbnail(@NotNull String url, @Nullable String proxy_url) {
		this.url = url;
		this.proxy_url = proxy_url;
	}

	/**
	 * Gets the URL of the thumbnail image.
	 *
	 * @return The URL of the thumbnail image.
	 */
	public String getURL() {
		return url;
	}

	/**
	 * Gets the proxied URL of the thumbnail image.
	 *
	 * @return The proxied URL of the thumbnail image.
	 */
	public String getProxyURL() {
		return proxy_url;
	}
}

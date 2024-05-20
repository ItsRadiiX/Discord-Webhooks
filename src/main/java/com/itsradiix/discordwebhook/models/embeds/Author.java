package com.itsradiix.discordwebhook.models.embeds;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Represents an Author of an embedded message.
 *
 * <p>Make sure to read the wiki page on our GitHub to understand how to use this effectively:
 * <a href="https://github.com/ItsRadiiX/Discord-Webhooks/wiki">Discord-Webhooks Wiki</a></p>
 *
 * @author ItsRadiiX
 * @version 2.0
 * @since 2024-05-19
 */

@SuppressWarnings("unused")
public class Author {

	// Author variables
	private final String name;
	private final String url;
	private final String icon_url;
	private final String proxy_icon_url;

	public Author(@NotNull String name, @Nullable String url, @Nullable String icon_url, @Nullable String proxy_icon_url) {
		this.name = name;
		this.url = url;
		this.icon_url = icon_url;
		this.proxy_icon_url = proxy_icon_url;
	}

	/**
	 * Gets the name of the author.
	 *
	 * @return The name of the author.
	 */
	public @NotNull String getName() {
		return name;
	}

	/**
	 * Gets the URL of the author.
	 *
	 * @return The URL of the author.
	 */
	public @Nullable String getURL() {
		return url;
	}

	/**
	 * Gets the Icon URL of the author.
	 *
	 * @return The Icon URL of the author.
	 */
	public @Nullable String getIconURL() {
		return icon_url;
	}

	/**
	 * Gets the Proxy Icon URL of the author.
	 *
	 * @return The Proxy Icon URL of the author.
	 */
	public @Nullable String getProxyIconURL() {
		return proxy_icon_url;
	}
}

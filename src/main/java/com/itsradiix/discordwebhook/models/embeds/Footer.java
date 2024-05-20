package com.itsradiix.discordwebhook.models.embeds;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Represents the footer of an embedded message.
 * Footers provide additional information at the bottom of an embedded message.
 *
 * <p>Make sure to read the wiki page on our GitHub to understand how to use this effectively:
 * <a href="https://github.com/ItsRadiiX/Definity-Webhooks/wiki">Definity-Webhooks Wiki</a></p>
 *
 * @author ItsRadiiX
 * @version 2.0
 * @since 2024-05-19
 */
public class Footer {

	/**
	 * The content of the footer.
	 */
	private final String text;

	/**
	 * The URL of the footer icon.
	 */
	private final String icon_url;

	/**
	 * The proxied URL of the footer icon.
	 */
	private final String proxy_icon_url;

	/**
	 * Constructs a Footer with the specified text and icon URLs.
	 *
	 * @param text The content of the footer.
	 * @param icon_url The URL of the footer icon.
	 * @param proxy_icon_url The proxied URL of the footer icon.
	 */
	public Footer(@NotNull String text, @Nullable String icon_url, @Nullable String proxy_icon_url) {
		this.text = text;
		this.icon_url = icon_url;
		this.proxy_icon_url = proxy_icon_url;
	}

	/**
	 * Gets the content of the footer.
	 *
	 * @return The content of the footer.
	 */
	public @NotNull String getText() {
		return text;
	}

	/**
	 * Gets the URL of the footer icon.
	 *
	 * @return The URL of the footer icon.
	 */
	public @Nullable String getIconURL() {
		return icon_url;
	}

	/**
	 * Gets the proxied URL of the footer icon.
	 *
	 * @return The proxied URL of the footer icon.
	 */
	public @Nullable String getProxyIconURL() {
		return proxy_icon_url;
	}
}

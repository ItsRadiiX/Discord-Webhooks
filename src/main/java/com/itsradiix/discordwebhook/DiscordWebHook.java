package com.itsradiix.discordwebhook;

import com.itsradiix.discordwebhook.embed.Embed;
import com.itsradiix.discordwebhook.utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Definity's DiscordWebhook allows for easy message sending to your Servers through a webhook!
 * This class represents a Discord Webhook Message, which can be customized with its internal Builder class.
 * Make sure to read the wiki page on our GitHub to understand how to use this effectively.
 * (https://github.com/ItsRadiiX/Definity-Webhooks/wiki)
 *
 * @author ItsRadiiX, GamingMineblox
 * @version 1.0
 * @since 2021-05-06
 */
public class DiscordWebHook {

	private final String username;
	private final String avatar_url;
	private final String content;
	private final List<Embed> embeds;

	/**
	 * Private constructor for creating an DiscordWebHook Message.
	 * This constructor is not public due to our internal Builder class.
	 * @param username This represents the username of the message that has been send.
	 * @param avatar_url This represents the icon of the message (Avatar).
	 * @param content This represents the text that will be displayed in the Message.
	 * @param embeds This represents all the embedded messages you can send in your WebHook message.
	 */
	private DiscordWebHook(String username, String avatar_url, String content, List<Embed> embeds) {
		this.username = username;
		this.avatar_url = avatar_url;
		this.content = content;
		this.embeds = embeds;
	}

	/**
	 * @return String Username of the WebHook Message.
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @return String Avatar_URL of the WebHook Message.
	 */
	public String getAvatar_url() {
		return avatar_url;
	}

	/**
	 * @return String Text content of the WebHook Message.
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @return List of Embed objects of the WebHook Message.
	 */
	public List<Embed> getEmbeds() {
		return embeds;
	}

	/**
	 * This static method will allow you to send your Object to the given WebHook through the URL
	 * @param URL This represents the link of the webhook.
	 * @param message This represents the Discord webhook object. (Creatable via the internal Builder)
	 */
	public static void sendMessage(String URL, DiscordWebHook message){
		Utils.postToAPI(URL, Utils.serializeObject(message));
	}

	/**
	 * The Builder class is used to easily build DiscordWebHook Objects.
	 * Make sure to read the wiki page on our GitHub to understand how to use this effectively.
	 * (https://github.com/ItsRadiiX/Definity-Webhooks/wiki)
	 */
	public static class Builder {

		// Builder variables
		private String username;
		private String avatar_url;
		private String content;
		private List<Embed> embeds;

		/**
		 * @param username Set the username of the DiscordWebHook message.
		 * @return Builder Object for further creation of this Builder class.
		 */
		public Builder username(String username){
			this.username = username;
			return this;
		}

		/**
		 * @param avatar_url Set the Avatar URL of the DiscordWebHook message.
		 * @return Builder Object for further creation of this Builder class.
		 */
		public Builder avatar_url(String avatar_url){
			this.avatar_url = avatar_url;
			return this;
		}

		/**
		 * @param content Set the text content of the DiscordWebHook message.
		 * @return Builder Object for further creation of this Builder class.
		 */
		public Builder content(String content){
			this.content = content;
			return this;
		}

		/**
		 * the embed() method adds an embedded message.
		 * If the list of embedded message does not exist yet it will be created automatically.
		 * @param embed Add an embedded message to your DiscordWebHook message.
		 * @return Builder Object for further creation of this Builder class.
		 */
		public Builder embed(Embed embed){
			if (embeds == null){ embeds = new ArrayList<>(); }
			embeds.add(embed);
			return this;
		}

		/**
		 * The build() method will allow you to finalize your Builder class by building the DiscordWebHook Object.
		 * IMPORTANT: Use this method at the end of your statement.
		 *
		 * @return DiscordWebHook Object to instantiate the DiscordWebHook.
		 */
		public DiscordWebHook build(){
			return new DiscordWebHook(username, avatar_url, content, embeds);
		}
	}
}

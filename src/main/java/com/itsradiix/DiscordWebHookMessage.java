package com.itsradiix;

import com.itsradiix.embed.Embed;
import com.itsradiix.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class DiscordWebHookMessage {

	private final String username;
	private final String avatar_url;
	private final String content;
	private final List<Embed> embeds;

	private DiscordWebHookMessage(String username, String avatar_url, String content, List<Embed> embeds) {
		this.username = username;
		this.avatar_url = avatar_url;
		this.content = content;
		this.embeds = embeds;
	}

	public String getUsername() {
		return username;
	}

	public String getAvatar_url() {
		return avatar_url;
	}

	public String getContent() {
		return content;
	}

	public List<Embed> getEmbeds() {
		return embeds;
	}

	public static void sendMessage(String URL, DiscordWebHookMessage message){
		Utils.postToAPI(URL, Utils.serializeObject(message));
	}

	public static class Builder {

		private String username;
		private String avatar_url;
		private String content;
		private List<Embed> embeds;

		public Builder username(String username){
			this.username = username;
			return this;
		}

		public Builder avatar_url(String avatar_url){
			this.avatar_url = avatar_url;
			return this;
		}

		public Builder content(String content){
			this.content = content;
			return this;
		}

		public Builder embed(Embed embed){
			if (embeds == null){ embeds = new ArrayList<>(); }
			embeds.add(embed);
			return this;
		}

		public DiscordWebHookMessage build(){
			return new DiscordWebHookMessage(username, avatar_url, content, embeds);
		}
	}
}

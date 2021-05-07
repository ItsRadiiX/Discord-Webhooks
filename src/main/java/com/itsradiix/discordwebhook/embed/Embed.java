package com.itsradiix.discordwebhook.embed;

import com.itsradiix.discordwebhook.embed.models.*;
import com.itsradiix.discordwebhook.utils.Utils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * The Embed class represents an Embedded Message that can be send with a DiscordWebHook message.
 * The Class has an internal Builder Class to easily instantiate an Object.
 * Make sure to read the wiki page on our GitHub to understand how to use this effectively.
 * https://github.com/ItsRadiiX/Definity-Webhooks/wiki
 */
public class Embed {

	// Important Embed variables
	private String title;
	private String description;
	private String url;
	private int color;
	private String timestamp;

	// Footer variable
	private Footer footer;

	// Thumbnail variable
	private Thumbnail thumbnail;

	// Image variable
	private Image image;

	// Author variable
	private Author author;

	// Fields variable
	private List<Field> fields;

	// Constructor
	public Embed(String title, String description, String url, int color, String timestamp,
	             Footer footer, Thumbnail thumbnail, Image image, Author author, List<Field> fields) {
		this.title = title;
		this.description = description;
		this.url = url;
		this.color = color;
		this.timestamp = timestamp;
		this.footer = footer;
		this.thumbnail = thumbnail;
		this.image = image;
		this.author = author;
		this.fields = fields;
	}

	/**
	 * This allows you to create an Embed without using the Builder class. (Not recommended)
	 */
	public Embed() {}

	/**
	 * @return String Title of the embedded message.
	 */
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return String Description of the embedded message.
	 */
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return String URL when clicked on the title.
	 */
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @return int Decimal color of the embedded message.
	 */
	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

	/**
	 * @return String of TimeStamp displayed in Footer.
	 */
	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	/**
	 * @return Footer Get the Footer Object of an embedded message.
	 */
	public Footer getFooter() {
		return footer;
	}

	public void setFooter(Footer footer) {
		this.footer = footer;
	}

	/**
	 * @return Thumbnail Get the Thumbnail Object of an embedded message.
	 */
	public Thumbnail getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(Thumbnail thumbnail) {
		this.thumbnail = thumbnail;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	/**
	 * @return Author Get the Author Object of an embedded message.
	 */
	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	/**
	 * @return List Get all Fields of an embedded message.
	 */
	public List<Field> getFields() {
		return fields;
	}

	public void setFields(List<Field> fields) {
		this.fields = fields;
	}

	/**
	 * The Builder class allows for easy creation of an Embed Object.
	 * Make sure to read the wiki page on our GitHub to understand how to use this effectively.
	 * (https://github.com/ItsRadiiX/Definity-Webhooks/wiki)
	 */
	public static class Builder {

		// Embed variables
		private String title;
		private String description;
		private String url;
		private int color;
		private String timestamp;

		// Footer
		private Footer footer;

		// Thumbnail
		private Thumbnail thumbnail;

		// Image
		private Image image;

		// Author
		private Author author;

		// Fields
		private List<Field> fields;

		public Builder title(String title){
			this.title = title;
			return this;
		}

		public Builder description(String description){
			this.description = description;
			return this;
		}

		public Builder url(String url){
			this.url = url;
			return this;
		}

		public Builder color(String hex){
			this.color = Utils.hexToDecimal(hex);
			return this;
		}

		public Builder timestamp(){
			this.timestamp = LocalDateTime.now().toString();
			return this;
		}

		public Builder footer( String text, String icon_url){
			this.footer = new Footer(text, icon_url);
			return this;
		}

		public Builder footer(String text){
			this.footer = new Footer(text);
			return this;
		}

		public Builder thumbnail(String url){
			this.thumbnail = new Thumbnail(url);
			return this;
		}

		public Builder image(String url){
			this.image = new Image(url);
			return this;
		}

		public Builder author(String name, String url, String icon_url){
			this.author = new Author(name, url, icon_url);
			return this;
		}

		public Builder author(String name, String url){
			this.author = new Author(name, url);
			return this;
		}

		public Builder field(String name, String value){
			if (fields == null){ fields = new ArrayList<>(); }
			fields.add(new Field(name, value));
			return this;
		}

		public Builder field(String name, String value, boolean inline){
			if (fields == null){ fields = new ArrayList<>(); }
			fields.add(new Field(name, value, inline));
			return this;
		}

		/**
		 * The build() method will allow you to finalize your Builder class by building the Embed Object.
		 * IMPORTANT: Use this method at the end of your statement.
		 *
		 * @return Embed Object to instantiate an Embed Object.
		 */
		public Embed build(){
			return new Embed(title, description, url, color, timestamp, footer, thumbnail, image, author, fields);
		}

	}
}
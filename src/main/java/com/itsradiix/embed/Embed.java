package com.itsradiix.embed;

import com.itsradiix.embed.models.*;
import com.itsradiix.utils.Utils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Embed {

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

	public Embed() {}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public Footer getFooter() {
		return footer;
	}

	public void setFooter(Footer footer) {
		this.footer = footer;
	}

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

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public List<Field> getFields() {
		return fields;
	}

	public void setFields(List<Field> fields) {
		this.fields = fields;
	}

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

		public Embed build(){
			return new Embed(title, description, url, color, timestamp, footer, thumbnail, image, author, fields);
		}

	}
}
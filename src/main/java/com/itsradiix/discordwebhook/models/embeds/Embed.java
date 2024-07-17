package com.itsradiix.discordwebhook.models.embeds;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Represents an embedded message that can be sent via a Discord webhook.
 * Embedded messages allow for richly formatted content to be displayed within the message.
 *
 * <p>Make sure to read the wiki page on our GitHub to understand how to use this effectively:
 * <a href="https://github.com/ItsRadiiX/Discord-Webhooks/wiki">Discord-Webhooks Wiki</a></p>
 *
 * @author ItsRadiiX
 * @version 2.0
 * @since 2024-05-19
 */

@SuppressWarnings("unused")
public class Embed {

	// Important Embed variables
	private String title;
	private String description;
	private String url;
	private String timestamp; /** ISO8601 timestamp - {@link LocalDateTime}*/
	private int color;

	// Footer variable
	private Footer footer;

	// Image variable
	private Image image;

	// Thumbnail variable
	private Thumbnail thumbnail;

	// Author variable
	private Author author;

	// Fields variable
	private List<Field> fields;

	// Constructor
	public Embed(String title, String description, String url, String hexColor, String timestamp,
				 Footer footer, Thumbnail thumbnail, Image image, Author author, List<Field> fields) {
		this.title = title;
		this.description = description;
		this.url = url;
		this.color = hexToDecimal(hexColor);
		this.timestamp = timestamp;
		this.footer = footer;
		this.thumbnail = thumbnail;
		this.image = image;
		this.author = author;
		this.fields = fields;
	}



	/**
	 * This allows you to create an Embed without using the Builder class.
	 */
	public Embed() {}

	/**
	 * @return String Title of the embedded message.
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the title of the embedded message.
	 *
	 * @param title The title of the embedded message.
	 * @return The Embed instance for method chaining.
	 */
	public Embed title(String title) {
		this.title = title;
		return this;
	}

	/**
	 * @return String Description of the embedded message.
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the description of the embedded message.
	 *
	 * @param description The description of the embedded message.
	 * @return The Embed instance for method chaining.
	 */
	public Embed description(String description) {
		this.description = description;
		return this;
	}

	/**
	 * @return String URL when clicked on the title.
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * Sets the URL when clicked on the title.
	 *
	 * @param url The URL when clicked on the title.
	 * @return The Embed instance for method chaining.
	 */
	public Embed url(String url) {
		this.url = url;
		return this;
	}

	/**
	 * @return int Decimal color of the embedded message.
	 */
	public int getColor() {
		return color;
	}

	/**
	 * Sets the decimal color of the embedded message.
	 *
	 * @param hexColor The Hex color of the embedded message.
	 * @return The Embed instance for method chaining.
	 */
	public Embed color(String hexColor) {
		this.color = hexToDecimal(hexColor);
		return this;
	}

	/**
	 * Sets the decimal color of the embedded message.
	 *
	 * @param decimalColor The decimal color of the embedded message.
	 * @return The Embed instance for method chaining.
	 */
	public Embed color(int decimalColor) {
		this.color = decimalColor;
		return this;
	}

	/**
	 * @return String Timestamp displayed in the footer.
	 */
	public String getTimestamp() {
		return timestamp;
	}

	/**
	 * Sets the timestamp displayed in the footer.
	 *
	 * @param timestamp The timestamp displayed in the footer.
	 * @return The Embed instance for method chaining.
	 */
	public Embed timestamp(String timestamp) {
		this.timestamp = timestamp;
		return this;
	}

	/**
	 * Sets the timestamp displayed in the footer.
	 *
	 * @param timestamp The timestamp displayed in the footer.
	 * @return The Embed instance for method chaining.
	 */
	public Embed timestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp.toString();
		return this;
	}

	/**
	 * Sets the timestamp displayed in the footer to now.
	 *
	 * @return The Embed instance for method chaining.
	 */
	public Embed timestampNow() {
		this.timestamp = LocalDateTime.now().toString();
		return this;
	}

	/**
	 * @return Footer The Footer object of an embedded message.
	 */
	public Footer getFooter() {
		return footer;
	}

	/**
	 * Sets the Footer object of an embedded message.
	 *
	 * @param footer The Footer object of an embedded message.
	 * @return The Embed instance for method chaining.
	 */
	public Embed footer(Footer footer) {
		this.footer = footer;
		return this;
	}

	/**
	 * @return Thumbnail The Thumbnail object of an embedded message.
	 */
	public Thumbnail getThumbnail() {
		return thumbnail;
	}

	/**
	 * Sets the Thumbnail object of an embedded message.
	 *
	 * @param thumbnail The Thumbnail object of an embedded message.
	 * @return The Embed instance for method chaining.
	 */
	public Embed thumbnail(Thumbnail thumbnail) {
		this.thumbnail = thumbnail;
		return this;
	}

	/**
	 * @return Image The Image object of an embedded message.
	 */
	public Image getImage() {
		return image;
	}

	/**
	 * Sets the Image object of an embedded message.
	 *
	 * @param image The Image object of an embedded message.
	 * @return The Embed instance for method chaining.
	 */
	public Embed image(Image image) {
		this.image = image;
		return this;
	}

	/**
	 * @return Author The Author object of an embedded message.
	 */
	public Author getAuthor() {
		return author;
	}

	/**
	 * Sets the Author object of an embedded message.
	 *
	 * @param author The Author object of an embedded message.
	 * @return The Embed instance for method chaining.
	 */
	public Embed author(Author author) {
		this.author = author;
		return this;
	}

	/**
	 * @return List The list of Fields of an embedded message.
	 */
	public List<Field> getFields() {
		return fields;
	}

	/**
	 * Sets the list of Fields of an embedded message.
	 *
	 * @param fields The list of Fields of an embedded message.
	 * @return The Embed instance for method chaining.
	 */
	public Embed fields(List<Field> fields) {
		this.fields = fields;
		return this;
	}

	/**
	 * Adds Fields to the list of Fields of an embedded message.
	 *
	 * @param fields The list of Fields of an embedded message.
	 * @return The Embed instance for method chaining.
	 */
	public Embed addFields(Field... fields){
		this.fields.addAll(Arrays.stream(fields).collect(Collectors.toList()));
		return this;
	}

	/**
	 * This static method will translate Hex color codes to Decimal color codes as that's Discords standard.
	 * You can use various tools to get a Hex color, like: https://htmlcolorcodes.com/
	 * @param hex Set the border color of your Embedded Message. This must be a Hex color code.
	 * @return Decimal color used by discord
	 */
	public static int hexToDecimal(String hex){
		return Integer.parseInt(hex.replace("#", ""), 16);
	}

}
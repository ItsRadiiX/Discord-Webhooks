package com.itsradiix.discordwebhook.models.embeds;

/**
 * Represents a field in an embedded message.
 * Fields provide structured data within the embedded message.
 *
 * <p>Make sure to read the wiki page on our GitHub to understand how to use this effectively:
 * <a href="https://github.com/ItsRadiiX/Discord-Webhooks/wiki">Discord-Webhooks Wiki</a></p>
 *
 * @author ItsRadiiX
 * @version 2.0
 * @since 2024-05-19
 */
public class Field {

	/**
	 * The name of the field.
	 */
	private final String name;

	/**
	 * The value of the field.
	 */
	private final String value;

	/**
	 * Whether the field should be displayed inline or not.
	 */
	private final boolean inline;

	/**
	 * Constructs a Field with the specified name, value, and inline setting.
	 *
	 * @param name The name of the field.
	 * @param value The value of the field.
	 */
	public Field(String name, String value) {
		this(name, value, false);
	}

	/**
	 * Constructs a Field with the specified name, value, and inline setting.
	 *
	 * @param name The name of the field.
	 * @param value The value of the field.
	 * @param inline Whether the field should be displayed inline or not.
	 */
	public Field(String name, String value, boolean inline) {
		this.name = checkIfEmpty(name);
		this.value = checkIfEmpty(value);
		this.inline = inline;
	}

	/**
	 * Checks whether the given string is empty.
	 * If empty, sets it to the Unicode for a space (U+200B).
	 *
	 * @param s The string to be checked.
	 * @return The string with the Unicode for a space set if it was empty.
	 */
	private String checkIfEmpty(String s){
		if (s.isEmpty()){
			s = "\\u200B";
		}
		return s;
	}

	/**
	 * Gets the name of the field.
	 *
	 * @return The name of the field.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Gets the value of the field.
	 *
	 * @return The value of the field.
	 */
	public String getValue() {
		return value;
	}

	/**
	 * Checks if the field should be displayed inline or not.
	 *
	 * @return True if the field should be displayed inline, false otherwise.
	 */
	public boolean isInline() {
		return inline;
	}
}

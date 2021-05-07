package com.itsradiix.discordwebhook.embed.models;

/**
 * The Field class represents a field in an embedded message.
 * Make sure to read the wiki page on our GitHub to understand how to use this effectively.
 * https://github.com/ItsRadiiX/Definity-Webhooks/wiki
 */
public class Field {

	// Important Field variables
	private final String name;
	private final String value;
	private final boolean inline;

	public Field(String name, String value) {
		this(name, value, false);
	}

	public Field(String name, String value, boolean inline) {
		this.name = checkIfEmpty(name);
		this.value = checkIfEmpty(value);
		this.inline = inline;
	}

	/**
	 * This method checks whether or not the Field is empty.
	 * If so, it will set the default UniCode for a Space, that way Discord API will not return a bad request.
	 * @param s String to be checked.
	 * @return String Returns String with UniCode for a Space Set.
	 */
	private String checkIfEmpty(String s){
		if (s.isEmpty()){
			s = "\\u200B";
		}
		return s;
	}

	/**
	 * @return String get name of a Field.
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return String get value of a Field.
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @return get if Field is inline or outline.
	 */
	public boolean isInline() {
		return inline;
	}
}

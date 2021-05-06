package com.itsradiix.embed.models;

public class Field {

	private final String name;
	private final String value;
	private final boolean inline;

	public Field(String name, String value) {
		this.name = checkIfEmpty(name);
		this.value = checkIfEmpty(value);
		inline = false;
	}

	public Field(String name, String value, boolean inline) {
		this.name = checkIfEmpty(name);
		this.value = checkIfEmpty(value);
		this.inline = inline;
	}

	public String checkIfEmpty(String s){
		if (s.isEmpty()){
			s = "\\u200B";
		}
		return s;
	}

	public String getName() {
		return name;
	}

	public String getValue() {
		return value;
	}

	public boolean isInline() {
		return inline;
	}
}

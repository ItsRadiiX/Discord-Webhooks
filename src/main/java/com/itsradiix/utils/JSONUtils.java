package com.itsradiix.utils;

import com.google.gson.Gson;

public abstract class JSONUtils {

	public static String serializeObject(Object object){
		Gson gson = new Gson();
		String tmp = gson.toJson(object);
		return parseUnicode(tmp);
	}

	private static String parseUnicode(String s){
		return s.replaceAll("\\\\u200B", "u200B");
	}

}

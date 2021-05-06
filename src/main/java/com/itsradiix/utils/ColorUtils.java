package com.itsradiix.utils;

public abstract class ColorUtils {

	public static int hexToDecimal(String hex){
		return Integer.parseInt(hex.replace("#", ""), 16);
	}

}

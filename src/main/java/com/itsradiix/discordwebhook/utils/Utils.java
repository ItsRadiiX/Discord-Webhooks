package com.itsradiix.discordwebhook.utils;

import com.google.gson.Gson;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;

/**
 * The Utils class contains important methods that we use across our project.
 * Currently the class is small enough to contain all these Methods.
 * If the class gets to large and becomes unreadable we will split the class into multiple different Utility classes.
 * This class should not be initialized, thus it is abstract.
 */
public abstract class Utils {

	/**
	 * This static method will translate Hex color codes to Decimal color codes as that's Discords standard.
	 * You can use various tools to get a Hex color, like: https://htmlcolorcodes.com/
	 * @param hex Set the border color of your Embedded Message. This must be a Hex color code.
	 * @return
	 */
	public static int hexToDecimal(String hex){
		return Integer.parseInt(hex.replace("#", ""), 16);
	}

	/**
	 * This static Method serializes an object to a JSON String using the GSON package.
	 * @param object Object to be serialized
	 * @return String returns the serialized Object as JSON String
	 */
	public static String serializeObject(Object object){
		Gson gson = new Gson();
		String tmp = gson.toJson(object);
		return parseUnicode(tmp);
	}

	/**
	 * This Method parses Unicode, this is not the ideal method but due to Java's String Class we have no other choice.
	 * Java's String class automatically encodes Unicode, which will make the Discord Server respond with an 400 HTML error code.
	 * @param s String to be parsed.
	 * @return String with UniCodes set.
	 */
	private static String parseUnicode(String s){
		return s.replaceAll("\\\\u200B", "u200B");
	}

	/**
	 * The postToAPI method can be used to post data to the API.
	 * @param route This is the used route to get data from the API.
	 * @param json This is the JSON Object as string that will be posted to the API
	 * @return Returns the response the API gave.
	 */
	public static String postToAPI(final String route, final String json) {

		final StringBuilder response = new StringBuilder();
		final Thread thread = new Thread(() -> {
			HttpsURLConnection con = null;
			try {
				URL url = new URL(route);
				con = (HttpsURLConnection) url.openConnection();
				con.setRequestMethod("POST");
				con.setRequestProperty("Content-Type", "application/json");
				con.setRequestProperty("Accept","application/json");
				con.setDoOutput(true);
				con.setDoInput(true);

				DataOutputStream os = new DataOutputStream(con.getOutputStream());
				os.writeBytes(json);

				os.flush();
				os.close();

				getResponse(con, response);

			} catch (Exception e) {
				e.printStackTrace();
			} if (con != null) {
				con.disconnect();
			}
		});
		thread.start();
		try {
			thread.join();
			return response.toString();
		} catch(InterruptedException e) {
			e.getCause();
			return null;
		}
	}

	/**
	 * This Method is used internally to get the response code from the Discord Server
	 * @param con This represents an HttpsURLConnection
	 * @param response This is the response from the Discord Server.
	 */
	private static void getResponse(HttpsURLConnection con, StringBuilder response) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), StandardCharsets.UTF_8));
			String responseLine;
			while ((responseLine = br.readLine()) != null) {
				response.append(responseLine.trim());
			}
		} catch (Exception e) {
			e.fillInStackTrace();
		}
	}

}

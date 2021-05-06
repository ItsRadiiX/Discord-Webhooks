package com.itsradiix.utils;

import com.google.gson.Gson;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class Utils {

	public static int hexToDecimal(String hex){
		return Integer.parseInt(hex.replace("#", ""), 16);
	}

	public static String serializeObject(Object object){
		Gson gson = new Gson();
		String tmp = gson.toJson(object);
		return parseUnicode(tmp);
	}

	private static String parseUnicode(String s){
		return s.replaceAll("\\\\u200B", "u200B");
	}

	/**
	 * The postToAPI method can be used to post data to the API.
	 * Our API Will return different kinds of data depending on what is provided on the specific route you use.
	 * @param route is the used route to get data from the API
	 * @param json this is the JSON Object / Array as string that will be posted to the API
	 * @return the response the API gave, in most cases this is going to be JSON as well, or a status code of some sort.
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

	private static void getResponse(HttpsURLConnection con, StringBuilder response) {
		try {
			if (con.getResponseCode() == 400) {
				BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), StandardCharsets.UTF_8));
				String responseLine;
				while ((responseLine = br.readLine()) != null) {
					response.append(responseLine.trim());
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

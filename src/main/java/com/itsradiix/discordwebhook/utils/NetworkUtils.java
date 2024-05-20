package com.itsradiix.discordwebhook.utils;

import com.google.gson.Gson;
import com.itsradiix.discordwebhook.DiscordFileWebHook;
import com.itsradiix.discordwebhook.DiscordWebHook;
import com.itsradiix.discordwebhook.models.WebHookFile;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.entity.mime.MultipartEntityBuilder;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.io.entity.StringEntity;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;

import static org.apache.hc.client5.http.impl.classic.HttpClients.createDefault;

/**
 * Utility Class that entails all needed networking methods.
 * You probably never need to do anything with this except for changing the ScheduledExecutorService.
 *
 * @author ItsRadiiX
 * @version 2.0
 * @since 2024-05-19
 */
public final class NetworkUtils {

    private static ScheduledExecutorService executorService = new ScheduledThreadPoolExecutor(2);

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
     * @param discordWebHook This is the JSON Object as string that will be posted to the API
     * @return Returns the response the API gave.
     */
    public static CloseableHttpResponse postRegularWebHookToAPI(final String route, DiscordWebHook discordWebHook) {

        Callable<CloseableHttpResponse> callable = () -> {
            try (CloseableHttpClient httpClient = createDefault()) {
                HttpPost upload = new HttpPost(route);
                upload.setEntity(new StringEntity(serializeObject(discordWebHook)));
                upload.setHeader("Content-Type", "application/json");
                upload.setHeader("Accept","application/json");

                return httpClient.execute(upload);
            }
        };

        try {
            Future<CloseableHttpResponse> future = executorService.submit(callable);
            return future.get();
        } catch (Exception e){
            throw new RuntimeException(e);
        }

    }

    /**
     * The postToAPI method can be used to post data to the API.
     * @param route This is the used route to get data from the API.
     * @param fileWebHook This is the JSON Object as string that will be posted to the API
     * @return Returns the response the API gave.
     */
    public static CloseableHttpResponse postFileWebHookToAPI(final String route, DiscordFileWebHook fileWebHook) {

        Callable<CloseableHttpResponse> callable = () -> {
            try (CloseableHttpClient httpClient = createDefault()) {
                HttpPost uploadFile = new HttpPost(route);

                MultipartEntityBuilder builder = MultipartEntityBuilder.create();
                builder.addTextBody("payload_json", serializeObject(fileWebHook.getWebhook()), ContentType.APPLICATION_JSON);

                List<WebHookFile> files = fileWebHook.getFiles();

                for (int i = 0; i < files.size(); i++) {
                    WebHookFile webHookFile = files.get(i);
                    builder.addBinaryBody(String.format("files[%d]", i),
                            Files.newInputStream(webHookFile.getFile().toPath()),
                            webHookFile.getContentType(),
                            webHookFile.getFile().getName());
                }
                HttpEntity multipart = builder.build();
                uploadFile.setEntity(multipart);
                return httpClient.execute(uploadFile);
            }
        };
        try {
            Future<CloseableHttpResponse> future = executorService.submit(callable);
            return future.get();
        } catch (Exception e){
            throw new RuntimeException(e);
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

    public static ScheduledExecutorService getExecutorService() {
        return executorService;
    }

    public static void setExecutorService(ScheduledExecutorService executorService) {
        NetworkUtils.executorService = executorService;
    }
}

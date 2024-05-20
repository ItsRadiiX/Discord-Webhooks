package com.itsradiix.discordwebhook;

import com.itsradiix.discordwebhook.models.WebHookFile;
import com.itsradiix.discordwebhook.utils.NetworkUtils;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;

import java.util.ArrayList;
import java.util.List;

/**
 * DiscordFileWebhook allows for easy message sending to your Servers through a webhook!
 * This class represents a Discord Webhook Message with the ability to send Files!
 * Make sure to read (<a href="https://github.com/ItsRadiiX/Definity-Webhooks/wiki">the wiki page on our GitHub</a>) to understand how to use this effectively.
 * Also make sure to understand (<a href="https://discord.com/developers/docs/resources/webhook">Discord's documentation of Webhooks</a>).
 *
 * @author ItsRadiiX
 * @version 2.0
 * @since 2024-05-19
 */
@SuppressWarnings("unused")
public class DiscordFileWebHook {

    /**
     * JSON encoded body of a regular Webhook
     */
    private DiscordWebHook payload_json;

    /**
     * The contents of the file being sent.
     */
    private List<WebHookFile> files;

    /**
     * Default constructor.
     */
    public DiscordFileWebHook() {}

    /**
     * Constructor with parameters.
     *
     * @param payload_json The JSON encoded body of non-file params.
     * @param files The list of files to be sent.
     */
    public DiscordFileWebHook(DiscordWebHook payload_json, List<WebHookFile> files) {
        this.payload_json = payload_json;
        this.files = files;
    }

    /**
     * Gets the JSON encoded body of the Webhook to be sent.
     *
     * @return The WebHook payload.
     */
    public DiscordWebHook getWebhook() {
        return payload_json;
    }

    /**
     * Gets the list of files to be sent.
     *
     * @return The list of files.
     */
    public List<WebHookFile> getFiles() {
        return files;
    }

    /**
     * Sets the JSON encoded body of non-file params.
     *
     * @param webhook The WebHook payload to set.
     * @return The FileWebHook instance.
     */
    public DiscordFileWebHook setWebhook(DiscordWebHook webhook){
        this.payload_json = webhook;
        return this;
    }

    /**
     * Adds one or more files to the list of files to be sent.
     *
     * @param files The files to add.
     * @return The FileWebHook instance.
     */
    public DiscordFileWebHook addFiles(WebHookFile... files){
        if (this.files == null) this.files = new ArrayList<>();
        for (WebHookFile file : files){
            if (this.files.contains(file)) continue;
            this.files.add(file);
        }
        return this;
    }

    /**
     *
     * @param webhookURL the url of the webhook to send a message to
     * @return HttpResponse containing feedback information
     */
    public CloseableHttpResponse sendToDiscord(final String webhookURL){
        return NetworkUtils.postFileWebHookToAPI(webhookURL, this);
    }
}
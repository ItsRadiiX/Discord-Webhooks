package com.itsradiix.discordwebhook;

import com.itsradiix.discordwebhook.models.Attachment;
import com.itsradiix.discordwebhook.models.Mentions;
import com.itsradiix.discordwebhook.models.embeds.Embed;
import com.itsradiix.discordwebhook.models.poll.Poll;
import com.itsradiix.discordwebhook.utils.NetworkUtils;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;

import java.util.List;

/**
 * DiscordWebHook allows for easy message sending to your Servers through a webhook!
 * This class represents a Discord Webhook Message.
 * Make sure to read (<a href="https://github.com/ItsRadiiX/Discord-Webhooks/wiki">the wiki page on our GitHub</a>) to understand how to use this effectively.
 * Also make sure to understand (<a href="https://discord.com/developers/docs/resources/webhook">Discord's documentation of Webhooks</a>).
 *
 * @author ItsRadiiX
 * @version 2.0
 * @since 2024-05-19
 */
@SuppressWarnings("unused")
public class DiscordWebHook {

    /**
     * Content of the Webhook.
     * Maximum length of 2000 characters.
     */
    private String content;

    /**
     * Overrides the default username of the webhook.
     */
    private String username;

    /**
     * Overrides the default avatar of the webhook.
     */
    private String avatar_url;

    /**
     * True if this is a Text-To-Speech message.
     */
    private boolean tts;

    /**
     * Embedded rich content.
     */
    private List<Embed> embeds;

    /**
     * Allowed mentions for the message.
     */
    private Mentions allowed_mentions;

    /**
     * Message flags combined as a bitfield.
     * (only SUPPRESS_EMBEDS and SUPPRESS_NOTIFICATIONS can be set)
     */
    private int flags;

    /**
     * Name of thread to create.
     * (requires the webhook channel to be a forum or media channel)
     */
    private String thread_name;

    /**
     * Array of tag ids to apply to the thread.
     * (requires the webhook channel to be a forum or media channel)
     */
    private List<Integer> applied_tags;

    /**
     * A poll!
     */
    private Poll poll;

    /**
     * Attachment objects with filename and description
     */
    private List<Attachment> attachments;

    /**
     * Default constructor.
     */
    public DiscordWebHook(){}

    /**
     * Constructor with parameters.
     *
     * @param content The content of the webhook message.
     * @param username The username to override the default webhook username.
     * @param avatar_url The avatar URL to override the default webhook avatar.
     * @param tts Whether the message should be sent as Text-To-Speech.
     * @param embeds The embedded rich content.
     * @param allowed_mentions The allowed mentions for the message.
     * @param flags The message flags combined as a bitfield.
     * @param thread_name The name of the thread to create.
     * @param applied_tags The array of tag ids to apply to the thread.
     * @param poll The poll to include in the message.
     */
    private DiscordWebHook(String content,
                           String username,
                           String avatar_url,
                           boolean tts,
                           List<Embed> embeds,
                           Mentions allowed_mentions,
                           int flags,
                           String thread_name,
                           List<Integer> applied_tags,
                           Poll poll) {
        this.content = content;
        this.username = username;
        this.avatar_url = avatar_url;
        this.tts = tts;
        this.embeds = embeds;
        this.allowed_mentions = allowed_mentions;
        this.flags = flags;
        this.thread_name = thread_name;
        this.applied_tags = applied_tags;
        this.poll = poll;
    }

    /**
     * Sets the content of the webhook message.
     *
     * @param content The content to set.
     * @return The WebHook instance.
     */
    public DiscordWebHook content(String content){
        this.content = content;
        return this;
    }

    /**
     * Sets the username to override the default webhook username.
     *
     * @param username The username to set.
     * @return The WebHook instance.
     */
    public DiscordWebHook username(String username){
        this.username = username;
        return this;
    }

    /**
     * Sets the avatar URL to override the default webhook avatar.
     *
     * @param avatar_url The avatar URL to set.
     * @return The WebHook instance.
     */
    public DiscordWebHook avatarUrl(String avatar_url){
        this.avatar_url = avatar_url;
        return this;
    }

    /**
     * Enables or disables Text-To-Speech for the message.
     *
     * @param enabled True to enable TTS, false to disable.
     * @return The WebHook instance.
     */
    public DiscordWebHook textToSpeech(boolean enabled){
        this.tts = enabled;
        return this;
    }

    /**
     * Sets the embedded rich content for the message.
     *
     * @param embeds The list of embeds to set.
     * @return The WebHook instance.
     */
    public DiscordWebHook setEmbeds(List<Embed> embeds){
        this.embeds = embeds;
        return this;
    }

    /**
     * Adds one or more embeds to the message.
     *
     * @param embeds The embeds to add.
     * @return The WebHook instance.
     */
    public DiscordWebHook addEmbeds(Embed... embeds){
        for (Embed embed : embeds){
            if (this.embeds.contains(embed)) continue;
            this.embeds.add(embed);
        }
        return this;
    }

    /**
     * Sets the allowed mentions for the message.
     *
     * @param mentions The mentions to set.
     * @return The WebHook instance.
     */
    public DiscordWebHook mentions(Mentions mentions){
        this.allowed_mentions = mentions;
        return this;
    }

    /**
     * Sets the message flags.
     *
     * @param flag The flag to set.
     * @return The WebHook instance.
     */
    public DiscordWebHook flags(int flag){
        this.flags = flag;
        return this;
    }

    /**
     * Sets the name of the thread to create.
     *
     * @param thread_name The thread name to set.
     * @return The WebHook instance.
     */
    public DiscordWebHook threadName(String thread_name){
        this.thread_name = thread_name;
        return this;
    }

    /**
     * Sets the tags to apply to the thread.
     *
     * @param applied_tags The list of tags to set.
     * @return The WebHook instance.
     */
    public DiscordWebHook setAppliedTags(List<Integer> applied_tags){
        this.applied_tags = applied_tags;
        return this;
    }

    /**
     * Adds one or more tags to the thread.
     *
     * @param applied_tags The tags to add.
     * @return The WebHook instance.
     */
    public DiscordWebHook addAppliedTags(int... applied_tags){
        for (int integer : applied_tags){
            if (this.applied_tags.contains(integer)) continue;
            this.applied_tags.add(integer);
        }
        return this;
    }

    /**
     * Sets the poll to include in the message.
     *
     * @param poll The poll to set.
     * @return The WebHook instance.
     */
    public DiscordWebHook poll(Poll poll){
        this.poll = poll;
        return this;
    }

    /**
     * Gets the content of the webhook message.
     *
     * @return The content.
     */
    public String getContent() {
        return content;
    }

    /**
     * Gets the username to override the default webhook username.
     *
     * @return The username.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Gets the avatar URL to override the default webhook avatar.
     *
     * @return The avatar URL.
     */
    public String getAvatar_url() {
        return avatar_url;
    }

    /**
     * Checks if the message is set to Text-To-Speech.
     *
     * @return True if TTS is enabled, false otherwise.
     */
    public boolean isTts() {
        return tts;
    }

    /**
     * Gets the list of embedded rich content.
     *
     * @return The list of embeds.
     */
    public List<Embed> getEmbeds() {
        return embeds;
    }

    /**
     * Gets the allowed mentions for the message.
     *
     * @return The allowed mentions.
     */
    public Mentions getAllowed_mentions() {
        return allowed_mentions;
    }

    /**
     * Gets the message flags.
     *
     * @return The flags.
     */
    public int getFlags() {
        return flags;
    }

    /**
     * Gets the name of the thread to create.
     *
     * @return The thread name.
     */
    public String getThread_name() {
        return thread_name;
    }

    /**
     * Gets the list of tags to apply to the thread.
     *
     * @return The list of applied tags.
     */
    public List<Integer> getApplied_tags() {
        return applied_tags;
    }

    /**
     * Gets the poll included in the message.
     *
     * @return The poll.
     */
    public Poll getPoll() {
        return poll;
    }

    /**
     * Gets the list of attachments for the message.
     *
     * @return The list of attachments.
     */
    public List<Attachment> getAttachments() {
        return attachments;
    }

    /**
     * Sends the webhook message to the specified Discord webhook URL.
     *
     * @param webhookURL The URL of the webhook to send a message to.
     * @return HttpResponse containing feedback information.
     */
    public CloseableHttpResponse sendToDiscord(final String webhookURL){
        return NetworkUtils.postRegularWebHookToAPI(webhookURL, this);
    }
}
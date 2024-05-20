package com.itsradiix.discordwebhook.models.poll;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Represents media content for a poll in a Discord webhook message.
 * Media content can consist of text and an optional emoji.
 *
 * <p>This class provides methods to retrieve the text and emoji associated with the poll media.</p>
 *
 * @author ItsRadiiX
 * @version 2.0
 * @since 2024-05-19
 */
public class PollMedia {
    /**
     * The text of the poll media.
     */
    private final String text;

    /**
     * The emoji of the poll media. This can be null.
     */
    private final Emoji emoji;

    /**
     * Constructs a PollMedia with the specified text and an optional emoji.
     *
     * @param text The text of the poll media. Must not be null.
     * @param emoji The emoji of the poll media. Can be null.
     */
    public PollMedia(@NotNull String text, @Nullable Emoji emoji) {
        this.text = text;
        this.emoji = emoji;
    }

    /**
     * Gets the text of the poll media.
     *
     * @return The text of the poll media.
     */
    public @NotNull String getText() {
        return text;
    }

    /**
     * Gets the emoji of the poll media.
     *
     * @return The emoji of the poll media, or null if there is no emoji.
     */
    public @Nullable Emoji getEmoji() {
        return emoji;
    }
}


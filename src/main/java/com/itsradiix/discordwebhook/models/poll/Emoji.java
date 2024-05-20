package com.itsradiix.discordwebhook.models.poll;

import org.jetbrains.annotations.Nullable;

/**
 * Represents an emoji in a Discord webhook message.
 * An emoji can be either a custom emoji with an ID or a default emoji with a name.
 *
 * <p>This class provides methods to retrieve the ID or name of the emoji.</p>
 *
 * @author ItsRadiiX
 * @version 2.0
 * @since 2024-05-19
 */
public class Emoji {
    /**
     * The ID of the custom emoji. Null if this is a default emoji.
     */
    private final Integer id;

    /**
     * The name of the default emoji. Null if this is a custom emoji.
     */
    private final String name;

    /**
     * Constructs an Emoji with the specified ID for a custom emoji.
     *
     * @param id The ID of the custom emoji.
     */
    public Emoji(int id) {
        this.id = id;
        this.name = null;
    }

    /**
     * Constructs an Emoji with the specified name for a default emoji.
     *
     * @param name The name of the default emoji.
     */
    public Emoji(String name) {
        this.name = name;
        this.id = null;
    }

    /**
     * Gets the ID of the custom emoji.
     *
     * @return The ID of the custom emoji, or null if this is a default emoji.
     */
    public @Nullable Integer getId() {
        return id;
    }

    /**
     * Gets the name of the default emoji.
     *
     * @return The name of the default emoji, or null if this is a custom emoji.
     */
    public @Nullable String getName() {
        return name;
    }
}


package com.itsradiix.discordwebhook.models;

/**
 * Represents an attachment in a Discord webhook message.
 * An attachment consists of an ID, a description, and a filename.
 *
 * <p>Used to attach files to a webhook message.</p>
 *
 * @author ItsRadiiX
 * @version 2.0
 * @since 2024-05-19
 */
public class Attachment {
    /**
     * The unique identifier for the attachment.
     */
    private final int id;

    /**
     * The description of the attachment.
     */
    private final String description;

    /**
     * The filename of the attachment.
     */
    private final String filename;

    /**
     * Constructs an Attachment with the specified ID, description, and filename.
     *
     * @param id The unique identifier for the attachment.
     * @param description The description of the attachment.
     * @param filename The filename of the attachment.
     */
    public Attachment(int id, String description, String filename) {
        this.id = id;
        this.description = description;
        this.filename = filename;
    }

    /**
     * Gets the unique identifier for the attachment.
     *
     * @return The ID of the attachment.
     */
    public int getId() {
        return id;
    }

    /**
     * Gets the description of the attachment.
     *
     * @return The description of the attachment.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Gets the filename of the attachment.
     *
     * @return The filename of the attachment.
     */
    public String getFilename() {
        return filename;
    }
}


package com.itsradiix.discordwebhook.models;

import org.apache.hc.core5.http.ContentType;
import java.io.File;

/**
 * Represents a file to be sent via a WebHook with its associated content type.
 *
 * @author ItsRadiiX
 * @version 2.0
 * @since 2024-05-19
 */
public class WebHookFile {

    private final File file;
    private final ContentType contentType;

    /**
     * Constructs a WebHookFile with the specified file and content type.
     *
     * @param file The file to be sent via the WebHook.
     * @param contentType The content type of the file.
     */
    public WebHookFile(File file, ContentType contentType) {
        this.file = file;
        this.contentType = contentType;
    }

    /**
     * Gets the file to be sent via the WebHook.
     *
     * @return The file.
     */
    public File getFile() {
        return file;
    }

    /**
     * Gets the content type of the file.
     *
     * @return The content type.
     */
    public ContentType getContentType() {
        return contentType;
    }
}

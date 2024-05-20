package com.itsradiix.discordwebhook.models.poll;

/**
 * Represents an answer in a Discord poll.
 * Each answer consists of media content, which can be text or other media types.
 *
 * <p>This class provides methods to retrieve the media content associated with the poll answer.</p>
 *
 * @author ItsRadiiX
 * @version 2.0
 * @since 2024-05-19
 */
public class PollAnswer {
    /**
     * The media content of the poll answer.
     */
    private final PollMedia poll_media;

    /**
     * Constructs a PollAnswer with the specified media content.
     *
     * @param poll_media The media content of the poll answer.
     */
    public PollAnswer(PollMedia poll_media) {
        this.poll_media = poll_media;
    }

    /**
     * Gets the media content of the poll answer.
     *
     * @return The media content of the poll answer.
     */
    public PollMedia getPollMedia() {
        return poll_media;
    }
}

package com.itsradiix.discordwebhook.models.poll;

import java.util.List;

/**
 * Represents a poll in a Discord webhook message.
 * A poll consists of a question, a list of answers, a duration, a multiselect option, and a layout type.
 *
 * <p>For more information, see the <a href="https://discord.com/developers/docs/resources/poll">Discord Poll Documentation</a>.</p>
 *
 * @author ItsRadiiX
 * @version 2.0
 * @since 2024-05-19
 */
public class Poll {
    /**
     * The question of the poll. Only text is supported.
     */
    private final PollMedia question;

    /**
     * Each of the answers available in the poll, up to 10.
     */
    private final List<PollAnswer> answers;

    /**
     * Number of hours the poll should be open for, up to 7 days.
     */
    private final int duration;

    /**
     * Whether a user can select multiple answers.
     */
    private final boolean allow_multiselect;

    /**
     * The layout type of the poll. Defaults to DEFAULT.
     */
    private final int layout_type;

    /**
     * Constructs a Poll with the specified question, answers, duration, and multiselect option.
     *
     * @param question The question of the poll.
     * @param answers The list of answers available in the poll.
     * @param duration The number of hours the poll should be open for.
     * @param allow_multiselect True if multiple answers can be selected, false otherwise.
     */
    public Poll(PollMedia question, List<PollAnswer> answers, int duration, boolean allow_multiselect) {
        this.question = question;
        this.answers = answers;
        this.duration = duration;
        this.allow_multiselect = allow_multiselect;
        this.layout_type = PollLayoutType.DEFAULT;
    }

    /**
     * Gets the question of the poll.
     *
     * @return The question of the poll.
     */
    public PollMedia getQuestion() {
        return question;
    }

    /**
     * Gets the list of answers available in the poll.
     *
     * @return The list of answers.
     */
    public List<PollAnswer> getAnswers() {
        return answers;
    }

    /**
     * Gets the duration the poll should be open for.
     *
     * @return The duration in hours.
     */
    public int getDuration() {
        return duration;
    }

    /**
     * Checks if multiple answers can be selected.
     *
     * @return True if multiple answers can be selected, false otherwise.
     */
    public boolean isMultiSelectAllowed() {
        return allow_multiselect;
    }

    /**
     * Gets the layout type of the poll.
     *
     * @return The layout type.
     */
    public int getLayoutType() {
        return layout_type;
    }
}

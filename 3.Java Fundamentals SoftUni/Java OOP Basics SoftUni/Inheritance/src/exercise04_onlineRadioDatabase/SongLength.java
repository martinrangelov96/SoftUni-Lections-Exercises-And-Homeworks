package exercise04_onlineRadioDatabase;

import exercise04_onlineRadioDatabase.constants.ExceptionConstants;
import exercise04_onlineRadioDatabase.exceptions.InvalidSongLengthException;
import exercise04_onlineRadioDatabase.exceptions.InvalidSongMinutesException;
import exercise04_onlineRadioDatabase.exceptions.InvalidSongSecondsException;

public class SongLength {
    private int minutes;
    private int seconds;

    public SongLength(String length) {
        this.parseSongLength(length);
    }

    private int getTotalSumLength(int minutes, int seconds) {
        return (minutes * 60) + seconds;
    }

    private void parseSongLength(String length) {
        String[] lengthTokens = length.split(":");
        String minutes = lengthTokens[0];
        String seconds = lengthTokens[1];

        if (lengthTokens.length != 2 || !minutes.matches("\\d+") || !seconds.matches("\\d+")) {
            throw new InvalidSongLengthException(ExceptionConstants.INVALID_SONG_LENGTH_EXCEPTION_MESSAGE);
        }

        int totalLength = this.getTotalSumLength(Integer.parseInt(minutes),
                Integer.parseInt(seconds));

        int minLength = 0;
        int maxLength = (14 * 60) + 59;

        if (totalLength < minLength || totalLength > maxLength) {
            throw new InvalidSongLengthException(ExceptionConstants.INVALID_SONG_LENGTH_EXCEPTION_MESSAGE);
        }

        this.setMinutes(Integer.parseInt(minutes));
        this.setSeconds(Integer.parseInt(seconds));

    }

    private void setMinutes(int minutes) {
        if (minutes < 0 || minutes > 14) {
            throw new InvalidSongMinutesException(ExceptionConstants.INVALID_SONG_LENGTH_MINUTES_EXCEPTION_MESSAGE);
        }
        this.minutes = minutes;
    }

    private void setSeconds(int seconds) {
        if (seconds < 0 || seconds > 59) {
            throw new InvalidSongSecondsException(ExceptionConstants.INVALID_SONG_LENGTH_SECONDS_EXCEPTION_MESSAGE);
        }
        this.seconds = seconds;
    }

    public int getMinutes() {
        return this.minutes;
    }

    public int getSeconds() {
        return this.seconds;
    }
}

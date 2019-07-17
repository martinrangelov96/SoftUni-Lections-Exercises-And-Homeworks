package exercise04_onlineRadioDatabase;

import exercise04_onlineRadioDatabase.constants.ExceptionConstants;
import exercise04_onlineRadioDatabase.exceptions.InvalidArtistNameException;
import exercise04_onlineRadioDatabase.exceptions.InvalidSongSecondsException;

public class Song {
    private String artistName;
    private String songName;
    private SongLength songLength;

    public Song(String artistName, String songName) {
        this.setArtistName(artistName);
        this.setSongName(songName);
    }

    public void setSongLength(SongLength songLength) {
        this.songLength = songLength;
    }

    private void setArtistName(String artistName) {
        if (artistName.length() < 3 || artistName.length() > 20) {
            throw new InvalidArtistNameException(ExceptionConstants.INVALID_SONG_ARTIST_NAME_SECONDS_EXCEPTION_MESSAGE);
        }
        this.artistName = artistName;
    }

    private void setSongName(String songName) {
        if (songName.length() < 3 || songName.length() > 20) {
            throw new InvalidSongSecondsException(ExceptionConstants.INVALID_SONG_NAME_SECONDS_EXCEPTION_MESSAGE);
        }
        this.songName = songName;
    }

    public SongLength getSongLength() {
        return this.songLength;
    }
}

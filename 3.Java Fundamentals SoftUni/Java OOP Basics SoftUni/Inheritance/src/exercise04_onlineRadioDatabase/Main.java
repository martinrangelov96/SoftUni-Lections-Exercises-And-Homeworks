package exercise04_onlineRadioDatabase;

import exercise04_onlineRadioDatabase.exceptions.InvalidSongException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int countOfSongs = Integer.parseInt(reader.readLine());

        RadioDataBase radioDataBase = new RadioDataBase();

        while (countOfSongs-- > 0) {
            String[] songTokens = reader.readLine().split(";");

            try {
                Song song = new Song(songTokens[0], songTokens[1]);
                SongLength songLength = new SongLength(songTokens[2]);

                song.setSongLength(songLength);

                radioDataBase.addSong(song);
                System.out.println("Song added.");
            } catch (InvalidSongException iae) {
                System.out.println(iae.getMessage());
            }

        }

        System.out.println(String.format("Songs added: %d",
                radioDataBase.getSongs().size()));
        System.out.println(radioDataBase.getPlaylistLength());

    }
}

import java.util.Scanner;

public class SongEncryption {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        while (!input.equals("end")) {

            String[] data = input.split(":");
            String artist = data[0];
            String song = data[1];

            int artistKey = artist.length();

            int newArtist = 0;
            String newestArtist = "";

            if (isValidArtist(artist) && isValidSong(song)) {
                for (int i = 0; i < artist.length(); i++) {
//                    if (artistKey > 122 || artistKey > 90) {
//                        newArtist = 'a';
//                    } else {
                        newArtist = artist.charAt(i) + artistKey;

                        if (artistKey > 112 || artistKey > 90) {
                            artistKey = 'a';
                        }
//                    }
                    char ch = (char) newArtist;
                    if (artist.charAt(i) == ' ') {
                        newestArtist += " ";
                    } else {
                        newestArtist += String.valueOf(ch);
                    }
                }
                System.out.printf("Successful encryption: %s@%s%n", newestArtist, song);
            } else {
                System.out.println("Invalid input!");
            }
            input = scanner.nextLine();
        }
    }

    private static boolean isValidSong(String song) {
        for (int i = 0; i < song.length(); i++) {
            if (!Character.isUpperCase(song.charAt(i)) && !Character.isWhitespace(song.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private static boolean isValidArtist(String artist) {
        if (Character.isUpperCase(artist.charAt(0))) {
            for (int j = 1; j < artist.length(); j++) {
                if (Character.isLetter(artist.charAt(j)) && !Character.isLowerCase(artist.charAt(j))) {
                    return false;
                }
            }
        } else {
            return false;
        }
        return true;
    }
}

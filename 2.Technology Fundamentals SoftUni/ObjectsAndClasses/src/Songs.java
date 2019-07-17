import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Songs {

    static class Song {
        private String typeList;
        private String name;
        private String time;

        public String getTypeList() {
            return typeList;
        }

        public void setTypeList(String typeList) {
            this.typeList = typeList;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfSongs = Integer.parseInt(scanner.nextLine());

        List<Song> songs = new ArrayList<>();

        for (int i = 0; i < numberOfSongs ; i++) {
            String[] tokens = scanner.nextLine().split("_");
            String typeList = tokens[0];
            String name = tokens[1];
            String time = tokens[2];

            Song song = new Song();

            song.setTypeList(typeList);
            song.setName(name);
            song.setTime(time);

            songs.add(song);
        }

        String outputList = scanner.nextLine();

        if (outputList.equals("all")) {
            for (Song song : songs) {
                System.out.println(song.name);
            }
        } else {
            for (Song song : songs) {
                if (song.getTypeList().equals(outputList)) {
                    System.out.println(song.getName());
                }
            }
        }

    }
}

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MeTube {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, Integer> videoAndViews = new HashMap<>();
        Map<String, Integer> videoAndLikes = new HashMap<>();

        while (!input.equals("stats time")) {

            if (input.contains("-")) {
                String[] data = input.split("-");
                String videoName = data[0];
                int views = Integer.parseInt(data[1]);

                if (!videoAndViews.containsKey(videoName)) {
                    videoAndViews.put(videoName, views);
                    videoAndLikes.put(videoName, 0);
                } else {
                    videoAndViews.put(videoName, videoAndViews.get(videoName) + views);
                }
            } else if (input.contains(":")) {
                String[] data = input.split(":");
                String likeOrDislike = data[0];
                String videoName = data[1];

                if (videoAndLikes.containsKey(videoName)) {
                    if (likeOrDislike.equals("like")) {
                        videoAndLikes.put(videoName, videoAndLikes.get(videoName) + 1);
                    } else if (likeOrDislike.equals("dislike")) {
                        videoAndLikes.put(videoName, videoAndLikes.get(videoName) - 1);
                    }
                }

            }

            input = scanner.nextLine();

        }

        input = scanner.nextLine();

        if (input.equals("by views")) {
            videoAndViews.entrySet().stream()
                    .sorted((v1, v2) -> {
                        return v2.getValue().compareTo(v1.getValue());
                    })
                    .forEach(entry -> {
                        System.out.printf("%s - %d views - %d likes%n", entry.getKey(), entry.getValue(), videoAndLikes.get(entry.getKey()));
                    });
        } else if (input.equals("by likes")) {
            videoAndLikes.entrySet().stream()
                    .sorted((e1, e2) -> {
                        return e2.getValue().compareTo(e1.getValue());
                    })
                    .forEach(entry -> {
                        System.out.printf("%s - %d views - %s likes%n", entry.getKey(), videoAndViews.get(entry.getKey()), entry.getValue());
                    });
        }

    }

}
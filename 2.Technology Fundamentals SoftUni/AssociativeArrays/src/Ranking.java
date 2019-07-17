import java.util.HashMap;
import java.util.Scanner;

public class Ranking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        HashMap<String, String> contestData = new HashMap<>();

        while (!input.equals("end of contests")) {
            String[] tokens = input.split(":");
            String contest = tokens[0];
            String passwordForContest = tokens[1];

            contestData.put(contest, passwordForContest);

            input = scanner.nextLine();
        }

        String secondInput = scanner.nextLine();

        HashMap<String, Integer> subjectPoints = new HashMap<>();
        HashMap<String, Integer> resultPoints = new HashMap<>();

        while (!secondInput.equals("end of submissions")) {
            String[] secondTokens = secondInput.split("=>");
            String secondContest = secondTokens[0];
            String secondPassword = secondTokens[1];
            String name = secondTokens[2];
            int points = Integer.parseInt(secondTokens[3]);

            subjectPoints.put(secondContest, points);
            resultPoints.put(name, points);
            //^ move these down

            if (contestData.containsKey(secondContest) && contestData.containsValue(secondPassword)) {
                if (subjectPoints.containsKey(secondContest)) {
                    if (subjectPoints.get(secondContest) < points) {
                        continue;
                    } else {
                        subjectPoints.put(secondContest, points);
                    }
                }
            } else {
                System.out.println("Fail");
            }

//            currentPoints = 0;

            secondInput = scanner.nextLine();
        }

        System.out.println();
    }
}

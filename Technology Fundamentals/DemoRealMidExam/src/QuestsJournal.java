import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class QuestsJournal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        List<String> quests = Arrays.stream(scanner.nextLine().split(", "))
                .collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("Retire!")) {
            String[] tokens = input.split(" - ");
            String command = tokens[0];

            switch (command) {
                case "Start": {
                    String topic = tokens[1];

                    if (!quests.contains(topic)) {
                        quests.add(topic);
                    } else {
                        continue;
                    }
                    break;
                }
                case "Complete": {
                    String topic = tokens[1];

                    quests.remove(topic);
                    break;
                }
                case "Side Quest": {
                    String[] sideTokens = tokens[1].split(":");
                    String topic = sideTokens[0];
                    String sideTopic = sideTokens[1];

                    if (quests.contains(topic)) {
                        if (!quests.contains(sideTopic)) {
                            quests.add(quests.indexOf(topic) + 1, sideTopic);
                        }
                    }
                    break;
                }
                case "Renew": {
                    String topic = tokens[1];

                    if (quests.contains(topic)) {
                        quests.remove(topic);
                        quests.add(quests.size(), topic);
                    }
                    break;
                }
            }

            input = scanner.nextLine();
        }

        for (int i = 0; i < quests.size(); i++) {
            if (quests.indexOf(quests.get(i)) == quests.size() - 1) {
                System.out.printf("%s", quests.get(i));
            } else {
                System.out.printf("%s, ", quests.get(i));
            }
        }

    }
}

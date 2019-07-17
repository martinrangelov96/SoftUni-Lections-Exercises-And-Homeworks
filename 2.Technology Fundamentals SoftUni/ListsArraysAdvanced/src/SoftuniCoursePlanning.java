import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SoftuniCoursePlanning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> subjects = Arrays.stream(scanner.nextLine().split(", "))
                .collect(Collectors.toList());


        String input = scanner.nextLine();

        String topicExercise = "";

        while (!input.equals("course start")) {
            String[] tokens = input.split(":");
            String command = tokens[0];

            if (command.equals("Add")) {
                String topic = tokens[1];

                if (!subjects.contains(topic)) {
                    subjects.add(topic);
                }
            } else if (command.equals("Insert")) {
                String topic = tokens[1];

                int index = Integer.parseInt(tokens[2]);

                if (!subjects.contains(topic)) {
                    subjects.add(index, topic);
                }
            } else if (command.equals("Remove")) {
                String topic = tokens[1];

                if (subjects.contains(topic)) {
                    subjects.remove(topic);
                }
                if (subjects.contains(topicExercise) && topicExercise.equals(topic+"-Exercise")) {
                    subjects.remove(topicExercise);
                }
            } else if (command.equals("Swap")) {
                String firstTopic = tokens[1];
                String secondTopic = tokens[2];

                if (subjects.contains(firstTopic) && subjects.contains(secondTopic)) {
                    Collections.swap(subjects, subjects.indexOf(firstTopic),subjects.indexOf(secondTopic));
                    if (subjects.contains(topicExercise)) {
                        if (topicExercise.equals(firstTopic+"-Exercise")) {
                            int index = subjects.indexOf(topicExercise);
                            subjects.add(subjects.indexOf(firstTopic) + 1, topicExercise);
                            //wrong/situational
                            subjects.remove(index + 1);
                        }
                        if (topicExercise.equals(secondTopic + "-Exercise")) {
                            int index = subjects.indexOf(topicExercise);
                            subjects.add(subjects.indexOf(secondTopic) + 1,topicExercise);
                            //wrong/situational
                            subjects.remove(index + 1);
                        }
                    }
                }

            } else if (command.equals("Exercise")) {
                String topic = tokens[1];
                topicExercise = tokens[1]+"-Exercise";

                if (!subjects.contains(topic) && !subjects.contains(topicExercise)) {
                    subjects.add(subjects.size(),topic);
                    subjects.add(subjects.size(),topicExercise);
                }

            }

            input = scanner.nextLine();
        }

        for (int i = 0; i < subjects.size() ; i++) {
            System.out.printf("%d.%s%n",i+1,subjects.get(i));
        }

    }
}

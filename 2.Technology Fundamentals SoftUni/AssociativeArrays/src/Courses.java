import java.util.*;
import java.util.stream.Collectors;

public class Courses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        LinkedHashMap<String, ArrayList<String>> coursesAndNames = new LinkedHashMap<>();

        while (!input.equals("end")) {
            String[] tokens = input.split(" : ");
            String course = tokens[0];
            String name = tokens[1];

            if (!coursesAndNames.containsKey(course)) {
                coursesAndNames.put(course, new ArrayList<>());
                coursesAndNames.get(course).add(name);
            } else {
                coursesAndNames.get(course).add(name);
                Collections.sort(coursesAndNames.get(course));
            }


            input = scanner.nextLine();
        }

        coursesAndNames.entrySet().stream().sorted((a, b) -> Integer.compare(b.getValue().size(),a.getValue().size()))
                .forEach(entry -> {
                    System.out.printf("%s: %d%n",entry.getKey(),entry.getValue().size());
                    for (int i = 0; i < entry.getValue().size() ; i++) {
                        System.out.printf("-- %s%n",entry.getValue().get(i));
                    }
                });
    }
}

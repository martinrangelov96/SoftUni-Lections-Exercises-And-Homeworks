import java.lang.reflect.Array;
import java.util.*;

public class StudentAcademy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        LinkedHashMap<String, ArrayList<Double>> studentsGrades = new LinkedHashMap<>();

        while (n-- > 0) {
            String name = scanner.nextLine();
            double grade = Double.parseDouble(scanner.nextLine());

            if (!studentsGrades.containsKey(name)) {
                studentsGrades.put(name, new ArrayList<>());
                studentsGrades.get(name).add(grade);
            } else {
                studentsGrades.get(name).add(grade);
            }

        }

        LinkedHashMap<String, Double> averageStudents = new LinkedHashMap<>();

        for (String name : studentsGrades.keySet()) {
            double sum = 0;
            for (int i = 0; i < studentsGrades.get(name).size(); i++) {
                sum += studentsGrades.get(name).get(i);
            }

            double average = sum / studentsGrades.get(name).size();

            if (average >= 4.50) {
                averageStudents.put(name, average);
            }
        }

        averageStudents.entrySet().stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .forEach(entry -> {
                    System.out.printf("%s -> %.2f%n", entry.getKey(), entry.getValue());
                });

    }
}

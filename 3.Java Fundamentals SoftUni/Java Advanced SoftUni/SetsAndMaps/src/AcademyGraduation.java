import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, double[]> students = new TreeMap<>();

        int studentsCount = Integer.parseInt(scanner.nextLine());

        while(studentsCount-- > 0) {
            String studentName = scanner.nextLine();
            double[] studentGrades = Arrays.stream(scanner.nextLine().split(" ")).mapToDouble(Double::parseDouble).toArray();

            students.put(studentName, studentGrades);
        }

        for(Map.Entry<String, double[]> studentEntry : students.entrySet()) {

            double avg = 0;
            for (double v : studentEntry.getValue()) {
                avg += v;
            }

            avg /= studentEntry.getValue().length;

            System.out.printf("%s is graduated with %s%n",studentEntry.getKey(), avg);
        }

    }
}

    import java.util.Scanner;

    public class Firm {

        public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);

            int projectHours = Integer.parseInt(scanner.nextLine());
            int availableDays = Integer.parseInt(scanner.nextLine());
            int workers = Integer.parseInt(scanner.nextLine());

            double workDays = availableDays * 0.90;
            double workHours = (workDays * workers) * 10;
            double totalHours = Math.floor(workHours);

            if (totalHours >= projectHours) {
                System.out.printf("Yes!%.0f hours left.", totalHours-projectHours);
            } else {
                System.out.printf("Not enough time!%.0f hours needed.", projectHours-totalHours);
            }


        }

    }

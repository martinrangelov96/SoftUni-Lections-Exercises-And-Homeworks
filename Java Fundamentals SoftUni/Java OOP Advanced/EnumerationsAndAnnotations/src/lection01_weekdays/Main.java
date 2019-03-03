package lection01_weekdays;

public class Main {
    public static void main(String[] args) {

        WeeklyCalendar wc = new WeeklyCalendar();
        wc.addEntry("Friday", "sleep");
        wc.addEntry("Monday", "sport");

        Iterable<WeeklyEntry> schedule = wc.getWeeklySchedule();

        for (WeeklyEntry weeklyEntry : schedule) {
            System.out.println(weeklyEntry);
        }


    }
}

package lection01_weekdays;

import java.util.Comparator;

public class WeeklyEntry {
    public static final Comparator<WeeklyEntry> WEEKLY_ENTRY_COMPARATOR = getComparator();

    private Weekday day;
    private String notes;

    public WeeklyEntry(String day, String notes) {
        this.day = Enum.valueOf(Weekday.class, day.toUpperCase());
        this.notes = notes;
    }

    @Override
    public String toString() {
        return String.format("%s - %s",this.day, this.notes);
    }

    private static Comparator<WeeklyEntry> getComparator() {
        return Comparator.comparing(e -> e.day.ordinal());
    }
}

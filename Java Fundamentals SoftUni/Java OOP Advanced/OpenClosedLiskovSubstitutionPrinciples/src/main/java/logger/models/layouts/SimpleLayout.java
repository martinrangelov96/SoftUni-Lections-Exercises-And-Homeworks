package logger.models.layouts;

import logger.interfaces.Layout;
import logger.models.enums.ReportLevel;

public class SimpleLayout implements Layout {
    @Override
    public String format(ReportLevel level, String date, String message) {
        return String.format("%s - %s - %s", date, level.name(), message);
    }
}

package logger.interfaces;

import logger.models.enums.ReportLevel;

public interface Layout {

    String format(ReportLevel level, String date, String message);
}

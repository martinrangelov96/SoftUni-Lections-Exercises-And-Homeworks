package logger.models.layouts;

import logger.interfaces.Layout;
import logger.models.enums.ReportLevel;

public class XmlLayout implements Layout {

    private final String LOG_OPEN_TAG = "<log>";
    private final String LOG_CLOSE_TAG = "</log>";
    private final String DATE_OPEN_TAG = "<date>";
    private final String DATE_CLOSE_TAG = "</date>";
    private final String LEVEL_OPEN_TAG = "<level>";
    private final String LEVEL_CLOSE_TAG = "</level>";
    private final String MESSAGE_OPEN_TAG = "<message>";
    private final String MESSAGE_CLOSE_TAG = "</message>";


    @Override
    public String format(ReportLevel level, String date, String message) {
        StringBuilder xmlBuilder = new StringBuilder();

        xmlBuilder
                .append(LOG_OPEN_TAG).append(System.lineSeparator())
                .append(DATE_OPEN_TAG)
                .append(date)
                .append(DATE_CLOSE_TAG).append(System.lineSeparator())
                .append(LEVEL_OPEN_TAG)
                .append(level.name())
                .append(LEVEL_CLOSE_TAG).append(System.lineSeparator())
                .append(MESSAGE_OPEN_TAG)
                .append(message)
                .append(MESSAGE_CLOSE_TAG).append(System.lineSeparator())
                .append(LOG_CLOSE_TAG);

        return xmlBuilder.toString();
    }
}

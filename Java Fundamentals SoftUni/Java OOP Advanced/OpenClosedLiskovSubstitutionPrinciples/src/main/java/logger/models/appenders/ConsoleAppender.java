package logger.models.appenders;

import logger.interfaces.Appender;
import logger.interfaces.Layout;
import logger.io.impl.ConsoleWriter;
import logger.io.interfaces.Writer;
import logger.models.enums.ReportLevel;

public class ConsoleAppender implements Appender {

    private final ReportLevel DEFAULT_REPORT_LEVEL = ReportLevel.INFO;

    private ReportLevel reportLevel;
    private Layout layout;
    private Writer writer;
    private int appendedMessagesCount;

    public ConsoleAppender(Layout layout) {
        this.layout = layout;
        this.reportLevel = DEFAULT_REPORT_LEVEL;
        this.writer = new ConsoleWriter();
    }

    @Override
    public void append(ReportLevel level, String date, String message) {
        if (level.ordinal() >= this.reportLevel.ordinal()) {
            String formattedLog = this.layout.format(level, date, message);

            this.writer.writeLine(formattedLog);
            this.appendedMessagesCount++;
        }
    }

    @Override
    public void setReportLevel(ReportLevel level) {
        this.reportLevel = level;
    }

    //Appender type: ConsoleAppender, Layout type: SimpleLayout, Report level: CRITICAL, Messages appended: 2
    //Appender type: FileAppender, Layout type: XmlLayout, Report level: INFO, Messages appended: 5, File size: 37526

    @Override
    public String toString() {
        return String.format("Appender type: %s, Layout type: %s, Report level: %s, Messages appended: %d",
                this.getClass().getSimpleName(),
                this.layout.getClass().getSimpleName(),
                this.reportLevel.name(),
                this.appendedMessagesCount);
    }
}

package logger.models.loggers;

import logger.interfaces.Appender;
import logger.interfaces.Logger;
import logger.io.interfaces.Writer;
import logger.models.enums.ReportLevel;

import java.util.Arrays;

public class MessageLogger implements Logger {

    private Appender[] appenders;

    public MessageLogger(Appender... appenders) {
        this.setAppenders(appenders);
    }

    private void setAppenders(Appender[] appenders) {
        if (appenders == null) {
            throw new IllegalStateException("Appenders cannot be null.");
        }
        this.appenders = appenders;
    }

    @Override
    public void logInfo(String date, String message) {
        ReportLevel reportLevel = ReportLevel.INFO;
        appendMessage(date, message, reportLevel);
    }

    @Override
    public void logWarning(String date, String message) {
        ReportLevel reportLevel = ReportLevel.WARNING;
        appendMessage(date, message, reportLevel);
    }

    @Override
    public void logError(String date, String message) {
        ReportLevel reportLevel = ReportLevel.ERROR;
        appendMessage(date, message, reportLevel);
    }

    @Override
    public void logCritical(String date, String message) {
        ReportLevel reportLevel = ReportLevel.CRITICAL;
        appendMessage(date, message, reportLevel);
    }

    @Override
    public void logFatal(String date, String message) {
        ReportLevel reportLevel = ReportLevel.FATAL;
        appendMessage(date, message, reportLevel);
    }

    @Override
    public void getInfo(Writer writer) {
        writer.writeLine("Logger info");

        Arrays.stream(this.appenders)
                .forEach(appender -> writer.writeLine(appender.toString()));
    }

    private void appendMessage(String date, String message, ReportLevel reportLevel) {
        if (this.appenders.length > 0) {
            Arrays.stream(this.appenders)
                    .forEach(appender -> appender.append(reportLevel, date, message));
        }
    }
}

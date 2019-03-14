package logger.interfaces;

import logger.io.interfaces.Writer;

public interface Logger {

    void logInfo(String date, String message);

    void logWarning(String date, String message);

    void logError(String date, String message);

    void logCritical(String date, String message);

    void logFatal(String date, String message);

    void getInfo(Writer writer);

}

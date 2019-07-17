package logger.core;

import logger.factories.AppenderFactory;
import logger.factories.LayoutFactory;
import logger.interfaces.Appender;
import logger.interfaces.Layout;
import logger.interfaces.Logger;
import logger.io.interfaces.Reader;
import logger.io.interfaces.Writer;
import logger.models.enums.ReportLevel;
import logger.models.loggers.MessageLogger;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Engine implements Runnable {

    private static final String TERMINATE_PROGRAM = "END";
    private final String DEFAULT_LOGGER_PREFIX = "log";

    private Writer writer;
    private Reader reader;
    private Logger logger;

    public Engine(Writer writer, Reader reader) {
        this.writer = writer;
        this.reader = reader;
    }

    @Override
    public void run() {
        addAppendersToThisLogger();

        String line;
        while (true) {
            line = reader.readLine();
            if (TERMINATE_PROGRAM.equals(line)) {
                break;
            }

            String[] messageTokens = line.split("\\|");
            logMessage(messageTokens);

        }

        this.logger.getInfo(this.writer);
    }

    private void logMessage(String[] messageTokens) {
        String level = messageTokens[0];
        String dateTime = messageTokens[1];
        String message = messageTokens[2];

        String methodName = DEFAULT_LOGGER_PREFIX
                + String.valueOf(level.charAt(0)) + level.substring(1).toLowerCase();

        try {
            Method method = this.logger.getClass().getDeclaredMethod(methodName, String.class, String.class);
            method.invoke(this.logger, dateTime, message);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private void addAppendersToThisLogger() {
        int numberOfAppender = Integer.parseInt(this.reader.readLine());
        Appender[] appenders = new Appender[numberOfAppender];

        for (int i = 0; i < numberOfAppender; i++) {
            String[] appenderTokens = reader.readLine().split("\\s+");
            String appenderType = appenderTokens[0];
            String layoutType = appenderTokens[1];

            Layout layout = LayoutFactory.create(layoutType);
            Appender appender = AppenderFactory.create(appenderType, layout);

            if (appenderTokens.length > 2) {
                String level = appenderTokens[2];
                appender.setReportLevel(Enum.valueOf(ReportLevel.class, level));
            }

            appenders[i] = appender;
        }

        this.logger = new MessageLogger(appenders);
    }
}

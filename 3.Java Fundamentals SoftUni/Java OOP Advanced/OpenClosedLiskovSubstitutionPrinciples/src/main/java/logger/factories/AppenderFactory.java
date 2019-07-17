package logger.factories;

import logger.interfaces.Appender;
import logger.interfaces.Layout;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class AppenderFactory {

    private static final String CLASS_PATH = "logger.models.appenders.";

    protected AppenderFactory() {

    }

    public static Appender create(String appenderType, Layout layout) {
        try {
            Class<?> appenderClass = Class.forName(CLASS_PATH + appenderType);
            Constructor<?> declaredConstructor = appenderClass.getDeclaredConstructor(Layout.class);

            return  (Appender) declaredConstructor.newInstance(layout);
        } catch (ClassNotFoundException
                | NoSuchMethodException
                | InstantiationException
                | IllegalAccessException
                | InvocationTargetException e) {
//            e.printStackTrace();
            return null;
        }
    }
}

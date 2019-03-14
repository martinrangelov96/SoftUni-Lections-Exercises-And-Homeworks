package logger.factories;

import logger.interfaces.Layout;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class LayoutFactory {

    private static final String CLASS_PATH = "logger.models.layouts.";

    protected LayoutFactory() {

    }

    public static Layout create(String layoutType) {

        try {
            Class<?> layoutClass = Class.forName(CLASS_PATH + layoutType);

            Constructor<?> declaredConstructor = layoutClass.getDeclaredConstructor();

            return (Layout) declaredConstructor.newInstance();

        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }

        return null;
    }
}

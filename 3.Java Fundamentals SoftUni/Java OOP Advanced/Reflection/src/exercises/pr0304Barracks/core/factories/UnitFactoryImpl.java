package exercises.pr0304Barracks.core.factories;

import exercises.pr0304Barracks.contracts.Unit;
import exercises.pr0304Barracks.contracts.UnitFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

    private static final String UNITS_PACKAGE_NAME =
            "exercises.pr0304Barracks.units.";

    @Override
    public Unit createUnit(String unitType) {
        Unit unit = null;
        try {
            Class<?> unitClass = Class.forName(UNITS_PACKAGE_NAME + unitType);
            Constructor<?> declaredConstructor = unitClass.getDeclaredConstructor();
            unit = (Unit) declaredConstructor.newInstance();
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return unit;
    }
}

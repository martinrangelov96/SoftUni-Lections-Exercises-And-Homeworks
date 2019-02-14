package java.main.interfaces;

import net.java.main.exceptions.InvalidPositionException;
import net.java.main.exceptions.InvalidUnitTypeException;
import net.java.main.exceptions.NotEnoughEnergyException;
import net.java.main.exceptions.UnitNotExistException;

import java.main.exceptions.NotEnoughEnergyException;

public interface Command {

    String execute(String[] args) throws InvalidUnitTypeException, InvalidPositionException, UnitNotExistException, NotEnoughEnergyException, NotEnoughEnergyException;
}

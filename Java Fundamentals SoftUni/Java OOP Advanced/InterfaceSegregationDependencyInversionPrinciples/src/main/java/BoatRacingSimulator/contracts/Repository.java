package BoatRacingSimulator.contracts;

import BoatRacingSimulator.exeptions.DuplicateModelException;
import BoatRacingSimulator.exeptions.NonExistentModelException;

public interface Repository<T extends Modelable> {
    void add(T item) throws DuplicateModelException;

    T getItem(String model) throws NonExistentModelException;
}

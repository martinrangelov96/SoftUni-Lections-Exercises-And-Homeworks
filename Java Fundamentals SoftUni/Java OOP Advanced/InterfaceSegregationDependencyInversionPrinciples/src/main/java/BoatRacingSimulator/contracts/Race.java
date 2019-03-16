package BoatRacingSimulator.contracts;

import BoatRacingSimulator.exeptions.DuplicateModelException;

import java.util.List;

public interface Race
{
    int getDistance();

    int getWindSpeed();

    int getOceanCurrentSpeed();

    Boolean getAllowsMotorboats();

    void addParticipant(Boat boat) throws DuplicateModelException;

    List<Boat> getParticipants();
}

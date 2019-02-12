package exercise08_militaryElite_unfinished.impl;

import exercise08_militaryElite_unfinished.contracts.SpecialisedSoldier;

public abstract class SpecialisedSoldierImpl extends PrivateImpl implements SpecialisedSoldier {

    private static final String AIR_FORCES_CORPS_TYPE = "Airforces";
    private static final String MARINES_CORPS_TYPE = "Marines";

    private String corps;

    protected SpecialisedSoldierImpl(String id, String firstName,
                                     String lastName, double salary, String corps) {
        super(id, firstName, lastName, salary);
        this.setCorps(corps);
    }

    private void setCorps(String corps) {
        if (!AIR_FORCES_CORPS_TYPE.equals(corps) && !MARINES_CORPS_TYPE.equals(corps)) {
            throw new IllegalArgumentException();
        }
        this.corps = corps;
    }
}

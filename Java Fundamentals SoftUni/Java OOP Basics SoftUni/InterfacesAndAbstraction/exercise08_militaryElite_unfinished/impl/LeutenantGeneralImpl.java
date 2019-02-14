package exercise08_militaryElite_unfinished.impl;

import exercise08_militaryElite_unfinished.contracts.LeutenantGeneral;
import exercise08_militaryElite_unfinished.contracts.Private;

import java.util.Set;

public class LeutenantGeneralImpl extends PrivateImpl implements LeutenantGeneral {

    private Set<Private> privates;

    public LeutenantGeneralImpl(String id,String firstName,
                                String lastName, double salary, Set<Private> privates) {
        super(id, firstName, lastName, salary);
        this.privates = privates;
    }

    @Override
    public String toString() {
        StringBuilder leutenantGeneral = new StringBuilder(super.toString()).append(System.lineSeparator());

        leutenantGeneral.append("Privates:");

        for (Private privateSoldier : this.privates) {
            leutenantGeneral.append(System.lineSeparator()).append("  " +privateSoldier);
        }

        return leutenantGeneral.toString();
    }
}

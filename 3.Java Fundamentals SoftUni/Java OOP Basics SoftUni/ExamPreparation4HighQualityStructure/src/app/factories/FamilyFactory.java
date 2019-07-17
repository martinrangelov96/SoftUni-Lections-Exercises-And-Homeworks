package app.factories;

import app.entities.Family;

public final class FamilyFactory {

    private FamilyFactory() {}

    public static Family createFamily(String familyId) {
        return new Family(familyId);
    }
}

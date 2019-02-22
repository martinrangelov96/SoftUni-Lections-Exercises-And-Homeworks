package app.entities;

import app.entities.colonists.Colonist;
import app.factories.FamilyFactory;

import java.util.*;

public class Colony {

    private int maxFamilyCount;
    private int maxFamilyCapacity;
    private Map<String, Family> families;

    public Colony(int maxFamilyCount, int maxFamilyCapacity) {
        this.maxFamilyCount = maxFamilyCount;
        this.maxFamilyCapacity = maxFamilyCapacity;
        this.families = new TreeMap<>();
    }

    public int getMaxFamilyCount() {
        return this.maxFamilyCount;
    }

    public int getMaxFamilyCapacity() {
        return this.maxFamilyCapacity;
    }

    public List<Colonist> getColonistsByFamilyId(String familyId) {
        return null;
    }


    public void removeColonist(String familyId, String memberId) {
        if (this.families.containsKey(familyId)) {
            this.families.get(familyId).removeMember(memberId);

            if (this.families.get(familyId).getMembers().isEmpty()) {
                this.removeFamily(familyId);
            }

        }
    }

    public void removeFamily(String familyId) {
        this.families.remove(familyId);
    }

    public void addColonist(Colonist colonist) {
        if (this.canAddColonist(colonist)) {
            String familyId = colonist.getFamilyId();
            if (!this.families.containsKey(familyId)) {
                Family family = FamilyFactory.createFamily(familyId);
                this.families.put(familyId, family);
            }
            this.families.get(familyId).addMember(colonist);
        }
    }

    public boolean canAddColonist(Colonist colonist) {
        String familyId = colonist.getFamilyId();
        if (this.families.containsKey(familyId)) {
            if (this.families.get(familyId).getMembers().size() < this.maxFamilyCapacity) {
                return true;
            }
            System.out.println("family is full");
        } else {
            if (this.families.size() < maxFamilyCount) {
                return true;
            }
            System.out.println("colony is full");
        }
        return false;
    }

    public void grow(int growYears) {
        this.families.values()
                .forEach(family -> family.getMembers().forEach(colonist -> colonist.grow(growYears)));
    }

    public int getPotential() {
        return this.families.values()
                .stream()
                .mapToInt(Family::getPotential)
                .sum();

    }


    //–	"families: {familyCount}/{maxFamilyCount}"
    //–	"-{familyId}: {colonistCount}/{familyCapacity}"
    public String getCapacity() {
        StringBuilder sb = new StringBuilder();

        sb
                .append(String.format("families: %d/%d", families.size(), this.maxFamilyCount))
                .append(System.lineSeparator());
        this.families.values()
                .forEach(family -> sb.append(String.format("-%s: %d/%d%n",
                        family.getId(), family.getMembers().size(), this.maxFamilyCapacity)));

        return sb.toString();
    }

    public Family getFamily(String familyId) {
        return this.families.get(familyId);
    }
}

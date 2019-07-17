package exercise12_infernoInfinityCompareTo;

import exercise13_createCustomClassAnnotation.CustomAnnotation;

@CustomAnnotation(author = "Pesho", revision = 3,
        description = "Used for Java OOP Advanced course - Enumerations and Annotations.", reviewers = "Pesho, Svetlio")
public class Weapon implements Comparable<Weapon> {
    private WeaponType weaponType;
    private GemType[] gems;
    private String name;
    private int minDamage;
    private int maxDamage;
    private int numberOfSockets;
    private int strength;
    private int agility;
    private int vitality;
    private double itemLevel;

    public Weapon(String weaponType, String name) {
        this.weaponType = Enum.valueOf(WeaponType.class, weaponType.toUpperCase());
        this.name = name;
        this.minDamage = this.weaponType.getMinDamage();
        this.maxDamage = this.weaponType.getMaxDamage();
        this.numberOfSockets = this.weaponType.getNumberOfSockets();
        this.strength = 0;
        this.agility = 0;
        this.vitality = 0;
        this.gems = new GemType[this.weaponType.getNumberOfSockets()];
        this.itemLevel = getItemLevel();
    }

    public void addSocket(int socketIndex, String gem) {
        if (socketIndex >= 0 && socketIndex < gems.length) {

            if (gems[socketIndex] != null) {
                removeSocket(socketIndex);
            }

            GemType gemType = GemType.valueOf(GemType.class, gem.toUpperCase());
            gems[socketIndex] = gemType;

            addBonusStats(gemType);
        }
    }

    public void removeSocket(int socketIndex) {
        if (gems[socketIndex] != null) {
            GemType gemType = gems[socketIndex];

            removeBonusStats(gemType);

            gems[socketIndex] = null;
        }
    }

    private void addBonusStats(GemType gemType) {
        this.strength += gemType.getStrength();
        this.minDamage += gemType.getStrength() * 2;
        this.maxDamage += gemType.getStrength() * 3;

        this.agility += gemType.getAgility();
        this.minDamage += gemType.getAgility() * 1;
        this.maxDamage += gemType.getAgility() * 4;

        this.vitality += gemType.getVitality();
    }

    private void removeBonusStats(GemType gemType) {
        this.strength -= gemType.getStrength();
        this.minDamage -= gemType.getStrength() * 2;
        this.maxDamage -= gemType.getStrength() * 3;

        this.agility -= gemType.getAgility();
        this.minDamage -= gemType.getAgility() * 1;
        this.maxDamage -= gemType.getAgility() * 4;

        this.vitality -= gemType.getVitality();
    }

    public double getItemLevel() {
        return ((double) (this.getMinDamage() + this.getMaxDamage()) / 2) + this.getStrength() + this.getAgility() + this.getVitality();
    }

    public String additionalPrint() {
        return String.format("%s: %d-%d Damage, +%d Strength, +%d Agility, +%d Vitality (Item Level: %.1f)",
                this.getName(), this.getMinDamage(), this.getMaxDamage(), this.getStrength(),
                this.getAgility(), this.getVitality(), this.getItemLevel());
    }

    public WeaponType getWeaponType() {
        return this.weaponType;
    }

    public GemType[] getGems() {
        return this.gems;
    }

    public String getName() {
        return this.name;
    }

    public int getMinDamage() {
        return this.minDamage;
    }

    public int getMaxDamage() {
        return this.maxDamage;
    }

    public int getNumberOfSockets() {
        return this.numberOfSockets;
    }

    public int getStrength() {
        return this.strength;
    }

    public int getAgility() {
        return this.agility;
    }

    public int getVitality() {
        return this.vitality;
    }

    @Override
    public int compareTo(Weapon otherWeapon) {
        return Double.compare(this.getItemLevel(), otherWeapon.getItemLevel());
    }

    @Override
    public String toString() {
        return String.format("%s: %d-%d Damage, +%d Strength, +%d Agility, +%d Vitality",
                this.getName(), this.getMinDamage(), this.getMaxDamage(), this.getStrength(), this.getAgility(), this.getVitality());
    }

}

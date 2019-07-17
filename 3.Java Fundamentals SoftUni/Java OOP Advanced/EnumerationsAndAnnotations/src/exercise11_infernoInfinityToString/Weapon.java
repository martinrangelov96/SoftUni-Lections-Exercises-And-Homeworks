package exercise11_infernoInfinityToString;

public class Weapon {
    private WeaponType weaponType;
    private GemType[] gems;
    private String name;
    private int minDamage;
    private int maxDamage;
    private int numberOfSockets;
    private int strength;
    private int agility;
    private int vitality;

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
    }

    public void addSocket(int socketIndex, String gem) {
        if (socketIndex >= 0 && socketIndex < gems.length) {

            if (gems[socketIndex] != null) {
                removeSocket(socketIndex);
            }

            GemType gemType = GemType.valueOf(GemType.class, gem.toUpperCase());
            gems[socketIndex] = gemType;

            this.strength += gemType.getStrength();
            this.minDamage += gemType.getStrength() * 2;
            this.maxDamage += gemType.getStrength() * 3;

            this.agility += gemType.getAgility();
            this.minDamage += gemType.getAgility() * 1;
            this.maxDamage += gemType.getAgility() * 4;

            this.vitality += gemType.getVitality();
        }
    }

    public void removeSocket(int socketIndex) {
        if (gems[socketIndex] != null) {
            GemType gemType = gems[socketIndex];

            this.strength -= gemType.getStrength();
            this.minDamage -= gemType.getStrength() * 2;
            this.maxDamage -= gemType.getStrength() * 3;

            this.agility -= gemType.getAgility();
            this.minDamage -= gemType.getAgility() * 1;
            this.maxDamage -= gemType.getAgility() * 4;

            this.vitality -= gemType.getVitality();

            gems[socketIndex] = null;
        }
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

    //Axe of Misfortune: 21-39 Damage, +7 Strength, +2 Agility, +5 Vitality
    @Override
    public String toString() {
        return String.format("%s: %d-%d Damage, +%d Strength, +%d Agility, +%d Vitality",
                this.getName(), this.getMinDamage(), this.getMaxDamage(), this.getStrength(), this.getAgility(), this.getVitality());
    }
}

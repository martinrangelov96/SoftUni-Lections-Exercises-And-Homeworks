package app.factories;

import app.entities.monuments.*;

public final class MonumentFactory {

    private MonumentFactory() {
    }

    public static Monument createMonument(String type, String name, int affinity) {

        switch (type) {
            case "Air":
                return new AirMonument(name, affinity);
            case "Water":
                return new WaterMonument(name, affinity);
            case "Fire":
                return new FireMonument(name, affinity);
            case "Earth":
                return new EarthMonument(name, affinity);
            default:
                return null;
        }

    }
}

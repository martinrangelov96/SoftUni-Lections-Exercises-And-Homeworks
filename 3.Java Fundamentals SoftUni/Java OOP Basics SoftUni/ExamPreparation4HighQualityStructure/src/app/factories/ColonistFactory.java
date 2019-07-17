//package app.factories;
//
//import app.entities.colonists.Colonist;
//import app.entities.colonists.engineers.HardwareEngineer;
//import app.entities.colonists.engineers.SoftwareEngineer;
//import app.entities.colonists.medics.GeneralPractitioner;
//import app.entities.colonists.medics.Surgeon;
//import app.entities.colonists.soldiers.Soldier;
//
//public final class ColonistFactory {
//
//    private ColonistFactory() {}
//
//    public static Colonist createColonist(String... parameters) {
//        String type = parameters[0];
//        String colonistId = parameters[1];
//        String familyId = parameters[2];
//        int talent = Integer.parseInt(parameters[3]);
//        int age = Integer.parseInt(parameters[4]);
//        String sign = (parameters.length == 6) ? parameters[5] : null;
//        switch (type) {
//            case "SoftwareEngineer":
//                return new SoftwareEngineer(colonistId, familyId, talent, age);
//            case "HardwareEngineer":
//                return new HardwareEngineer(colonistId, familyId, talent, age);
//            case "Soldier":
//                return new Soldier(colonistId, familyId, talent, age);
//            case "GeneralPractitioner":
//                return new GeneralPractitioner(colonistId, familyId, talent, age, sign);
//            case "Surgeon":
//                return new Surgeon(colonistId, familyId, talent, age, sign);
//        }
//        return null;
//    }
//}

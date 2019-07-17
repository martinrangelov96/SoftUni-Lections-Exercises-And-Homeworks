import java.lang.reflect.Array;
import java.util.*;

public class DragonArmy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Integer>> typeAndName = new LinkedHashMap<>();
//        Map<String, ArrayList<Integer>> nameAndStats = new HashMap<>();

        int defaultHealth = 250;
        int defaultDamage = 45;
        int defaultArmor = 10;

        int numberOfInputs = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numberOfInputs; i++) {
            String[] data = scanner.nextLine().split("\\s+");
            String type = data[0];
            String name = data[1];
            String damage = data[2];
            if ("null".equals(damage)) {
                damage = String.valueOf(defaultDamage);
            }
            String health = data[3];
            if ("null".equals(health)) {
                health = String.valueOf(defaultHealth);
            }
            String armor = data[4];
            if ("null".equals(armor)) {
                armor = String.valueOf(defaultArmor);
            }
//            int[] stats = new int[3];
//            stats[0] = Integer.parseInt(damage);
//            stats[1] = Integer.parseInt(health);
//            stats[2] = Integer.parseInt(armor);

            Map<String, Integer> stats = new HashMap<>();

            if (!typeAndName.containsKey(type)) {
                stats = typeAndName.get(name);
//                typeAndName.put(type, new LinkedHashMap<>());
//                typeAndName.get(type).put(name, typ);
//                typeAndName.put(name, new ArrayList<>());
//                typeAndName.get(name).put(name, Integer.valueOf(damage));
//                typeAndName.get(name).put(name, Integer.valueOf(health));
//                typeAndName.get(name).put(name, Integer.valueOf(armor));
            }

            stats.put("damage", Integer.valueOf(damage));
            stats.put("health", Integer.valueOf(health));
            stats.put("armor", Integer.valueOf(armor));
            typeAndName.put(name, stats);

        }

        System.out.println();


    }
}

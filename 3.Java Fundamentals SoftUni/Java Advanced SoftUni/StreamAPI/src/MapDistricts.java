import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapDistricts {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, List<Integer>> cities = new HashMap<>();

//        Pld:9 Pld:13 Has:7 Sof:20 Sof:10 Sof:15
//        10

        String[] input = reader.readLine().split("\\s+");
        int populationBound = Integer.parseInt(reader.readLine());
        addCitiesToMap(cities, input);

        cities.entrySet()
                .stream()
                .filter(kv -> kv.getValue().stream()
                        .reduce((x, y) -> x + y).get() > populationBound)
                .sorted((kv1, kv2) -> {
                    int kv1Sum = kv1.getValue().stream().reduce((x, y) -> x + y).get();
                    int kv2Sum = kv2.getValue().stream().reduce((x, y) -> x + y).get();
                    return Integer.compare(kv2Sum, kv1Sum);
                }).forEach(kv -> {
            System.out.print(kv.getKey() + ": ");
            kv.getValue().stream().sorted((x,y) -> Integer.compare(y,x))
                    .limit(5)
                    .forEach(p -> System.out.print(p + " "));
            System.out.println();
        });


    }

    private static void addCitiesToMap(Map<String, List<Integer>> cities, String[] input) {
        for (String city : input) {
            String[] cityArgs = city.split(":");
            String cityName = cityArgs[0];
            int cityDistrict = Integer.parseInt(cityArgs[1]);

            if (!cities.containsKey(cityName)) {
                cities.put(cityName, new ArrayList<>());
            }

            cities.get(cityName).add(cityDistrict);
        }
    }
}

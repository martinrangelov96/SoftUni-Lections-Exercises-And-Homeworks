import java.util.*;

public class Concert {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        Map<String, ArrayList<String>> bandAndMembers = new HashMap<>();
        Map<String, Integer> bandAndTimePlayed = new HashMap<>();

        while (!input.equals("start of concert")) {

            String[] data = input.split("; ");

            String command = data[0];
            String bandName = data[1];
            String[] actualMembers = Arrays.copyOfRange(data, 2, data.length);
            String members = actualMembers[0];

            if (command.equals("Add")) {

                if (!bandAndMembers.containsKey(bandName)) {
                    bandAndMembers.put(bandName, new ArrayList<>());
                    bandAndMembers.get(bandName).add(members);
                } else {

                    for (Map.Entry<String, ArrayList<String>> entry : bandAndMembers.entrySet()) {
                        List<String> membersMembers = entry.getValue();
                        if (!membersMembers.contains(members)) {
                            bandAndMembers.get(bandName).add(members);
                        }
                    }

//                    for (int i = 0; i < actualMembers.length ; i++) {
//                        if (bandAndMembers.get(bandName).contains(actualMembers[i])) {
//                            continue;
//                        } else {
//                            bandAndMembers.get(bandName).add(actualMembers[i]);
//                        }
//                    }
                }

            } else if (command.equals("Play")) {



            }


            input = scanner.nextLine();
        }

    }
}

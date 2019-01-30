import java.util.*;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> phoneBook = new HashMap<>();
        phoneBook.put("Lisa Smith", new ArrayList<>());
        phoneBook.put("John Smith",new ArrayList<>());
        phoneBook.put("Sam Doe",new ArrayList<>());

        List<String> phonesOfJohn = phoneBook.get("John Smith");
        phonesOfJohn.add("3232-42421");
        phonesOfJohn.add("122-5871");

        phoneBook.get("Sam Doe").add("666-777");

        for (Map.Entry<String, List<String>> nameAndPhones : phoneBook.entrySet()) {
            System.out.println(nameAndPhones.getKey());
            List<String> phones = nameAndPhones.getValue();
            for (String phone : phones) {
                System.out.println("    -   " + phone);
            }
        }

        List<Integer> nums = Arrays.asList(5,2,14,2);

    }
}

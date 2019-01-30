import java.util.*;

public class Demo {

    static class Person {
        private String name;
        private String lastName;
        private int age;
        private String PIN;

        public Person(String name, String lastName, int age, String PIN) {
            this.name = name;
            this.lastName = lastName;
            this.age = age;
            this.PIN = PIN;
        }

        @Override
        public String toString() {
            return this.PIN + ": " + this.name + " " + this.lastName + " (" + this.age + ")";
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, List<Person>> peopleByCountry = new TreeMap<>();

        String line = sc.nextLine();

        while (!line.equals("end")) {
            String[] tokens = line.split(" ");
            if (tokens.length == 5) {
                String country = tokens[0];
                String name = tokens[1];
                String lastName = tokens[2];
                int age = Integer.parseInt(tokens[4]);
                String PIN = tokens[3];

                peopleByCountry.putIfAbsent(country, new ArrayList<>());
                Person person = new Person(name, lastName, age, PIN);
                peopleByCountry.get(country).add(person);
                System.out.println("We have added " + person + " into " + country);
            } else {
                tokens = line.split("-");
                String country = tokens[0];
                String PIN = tokens[1];
                String cmd = tokens[2];
                String fieldToChange = tokens[3];
                String value = tokens[4];

//                List<Person> peopleInThatCountry = peopleByCountry.get(country);
//                Person locatedPerson = null;
//                for(Person person: peopleInThatCountry) {
//                    if (person.PIN.equals(PIN)) {
//                        locatedPerson = person;
//                        break;
//                    }
//                }

                peopleByCountry.get(country)
                        .stream()
                        .filter(p -> p.PIN.equals(PIN))
                        .findFirst()
                        .ifPresent(locatedPerson -> {
                            switch (cmd) {
                                case "add":
                                    switch (fieldToChange) {
                                        case "name":
                                            locatedPerson.name += value;
                                            break;
                                        case "lastName":
                                            locatedPerson.lastName += value;
                                            break;
                                        case "age":
                                            locatedPerson.age += Integer.parseInt(value);
                                            break;
                                    }
                                    break;
                                case "change":
                                    switch (fieldToChange) {
                                        case "name":
                                            locatedPerson.name = value;
                                            break;
                                        case "lastName":
                                            locatedPerson.lastName = value;
                                            break;
                                        case "age":
                                            locatedPerson.age = Integer.parseInt(value);
                                            break;
                                    }
                                    break;
                                default:
                                    break;
                            }
                        });
            }
            line = sc.nextLine();
        }

        peopleByCountry.entrySet().stream()
                .sorted(Comparator.comparingInt(es -> es.getValue().size()))
                .forEach(es -> {
                    System.out.println("Country: " + es.getKey());
                    es.getValue().sort(Comparator.comparing(p -> p.PIN));
                    es.getValue().forEach(System.out::println);
                });

    }
}
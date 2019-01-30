import java.util.*;

public class CompanyRoster {

    static class Employee {
        private String name;
        private double salary;
        private String position;
        private String department;
        private String email;
        private int age;

        public Employee(String name, double salary, String position, String department, String email, int age) {
            this.name = name;
            this.salary = salary;
            this.position = position;
            this.department = department;
            this.email = email;
            this.age = age;
        }

        public Employee(String name, double salary, String position, String department, int age) {
            this.name = name;
            this.salary = salary;
            this.position = position;
            this.department = department;
            this.age = age;
        }

        public Employee(String name, double salary, String position, String department, String email) {
            this.name = name;
            this.salary = salary;
            this.position = position;
            this.department = department;
            this.email = email;
        }

        public Employee(String name, double salary, String position, String department) {
            this.name = name;
            this.salary = salary;
            this.position = position;
            this.department = department;
        }

        public Employee(String department) {
            this.department = department;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getSalary() {
            return salary;
        }

        public void setSalary(double salary) {
            this.salary = salary;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }

        public String getDepartment() {
            return department;
        }

        public void setDepartment(String department) {
            this.department = department;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            if (email == null) {
                this.email = "n/a";
                return;
            }
                this.email = email;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            if (age == 0) {
                this.age = -1;
                return;
            }
            this.age = age;
        }

    }

    class Department {
        private String nameOfDepartment;
        private List<Employee> employees;

        public Department(String nameOfDepartment, List<Employee> employees) {
            this.nameOfDepartment = nameOfDepartment;
            this.employees = employees;
        }

        public String getNameOfDepartment() {
            return nameOfDepartment;
        }

        public void setNameOfDepartment(String nameOfDepartment) {
            this.nameOfDepartment = nameOfDepartment;
        }

        public List<Employee> getEmployees() {
            return employees;
        }

        public void setEmployees(List<Employee> employees) {
            this.employees = employees;
        }

        public void addEmployee(Employee e) {
            this.employees.add(e);
        }

        public double getAverage() {
            double res = 0.0;

            for (Employee e : this.employees) {
                res += e.getSalary();
            }
            return res / this.employees.size();
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        HashMap<String, List<Employee>> departments = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String name = tokens[0];
            double salary = Double.parseDouble(tokens[1]);
            String position = tokens[2];
            String department = tokens[3];

            Employee employee = new Employee(name, salary, position, department);

            if (tokens.length == 5) {
                if (tokens[4].contains("@")) {
                    employee.setEmail(tokens[4]);
                } else {
                    employee.setAge(Integer.parseInt(tokens[4]));
                }
            } else if (tokens.length > 5) {
                employee.setEmail(tokens[4]);
                employee.setAge(Integer.parseInt(tokens[5]));
            }

            if (!departments.containsKey(employee.getDepartment())) {
                departments.put(employee.getDepartment(), new ArrayList<>());
                departments.get(department).add(employee);
            } else {
                departments.get(department).add(employee);
            }

        }

        System.out.println();


        HashMap<String, Double> averages = new HashMap<>();

        departments.forEach((key, value) -> {
            double a = value.stream().mapToDouble(Employee::getSalary).average().getAsDouble();
            averages.put(key, a);
        });

        String departmentWithHighestSalary =
                Collections.max(averages.entrySet(), (entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1).getKey();

        List<Employee> employeeList = new ArrayList<>();

        employeeList.stream()
                .filter(e -> e.getDepartment().equals(departmentWithHighestSalary))
                .sorted((e1,e2) -> Double.compare(e2.getSalary(),e1.getSalary()))
                .forEach(System.out::println);

    }
}
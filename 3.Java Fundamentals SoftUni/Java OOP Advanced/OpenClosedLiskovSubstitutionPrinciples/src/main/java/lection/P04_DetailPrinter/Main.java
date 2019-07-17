package lection.P04_DetailPrinter;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        //QA IS-SUBSTITUTED-FOR Employee
        final Employee employee = new QA("emp");
        final Developer dev = new Developer("dev", "project");
        final Manager manager = new Manager(
                "manager",
                new ArrayList<String>() {{
                    add("doc1");
                    add("doc2");
                    add("doc3");
                }}
        );

        final QA qa = new QA("qa");

        DetailsPrinter detailsPrinter = new DetailsPrinter(new ArrayList<Employee>() {{
            add(employee);
            add(dev);
            add(manager);
            add(qa);
        }});

        detailsPrinter.printDetails();

    }
}

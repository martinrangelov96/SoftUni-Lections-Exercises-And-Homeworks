package p03_employee_info;

import p03_employee_info.contracts.EmployeeInfoProvider;
import p03_employee_info.contracts.Engine;
import p03_employee_info.contracts.Formatter;
import p03_employee_info.contracts.Writer;

public class Main {

    public static void main(String[] args) {
        EmployeeInfoProvider employeeInfo =
                new EmployeeInfoProviderImpl(new EmployeeDatabase());

        Writer consoleWriter = new ConsoleWriter();
        Formatter formatter = new ConsoleFormatter();

        Engine engine = new EngineImpl(employeeInfo, consoleWriter, formatter);

        engine.run();
    }
}

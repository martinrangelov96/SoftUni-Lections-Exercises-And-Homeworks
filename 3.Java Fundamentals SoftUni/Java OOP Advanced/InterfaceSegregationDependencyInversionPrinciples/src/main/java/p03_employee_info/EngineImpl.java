package p03_employee_info;

import p03_employee_info.contracts.EmployeeInfoProvider;
import p03_employee_info.contracts.Engine;
import p03_employee_info.contracts.Formatter;
import p03_employee_info.contracts.Writer;

public class EngineImpl implements Engine {
    private EmployeeInfoProvider employeeInfo;
    private Writer writer;
    private Formatter formatter;

    public EngineImpl(EmployeeInfoProvider employeeInfo, Writer writer, Formatter formatter) {
        this.employeeInfo = employeeInfo;
        this.writer = writer;
        this.formatter = formatter;
    }

    @Override
    public void run() {
        writer.writeLine(this.formatter.format(employeeInfo.getEmployeesByName()));
    }
}

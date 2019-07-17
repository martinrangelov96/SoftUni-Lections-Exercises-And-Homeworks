package app.task05_bills_payment_system;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "bank_accounts")
public class BankAccount extends BillingDetail{

    private String name;
    private String swiftCode;

    public BankAccount() {
    }

    @Column(name = "name")
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "swift_code")
    public String getSwiftCode() {
        return this.swiftCode;
    }

    public void setSwiftCode(String swiftCode) {
        this.swiftCode = swiftCode;
    }
}

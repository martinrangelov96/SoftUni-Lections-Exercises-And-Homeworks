package app.task05_bills_payment_system;

import app.task05_bills_payment_system.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity(name = "users")
public class User extends BaseEntity {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Set<BillingDetail> billingDetail;

    public User() {
    }

    @Column(name = "first_name")
    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "last_name")
    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "email")
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "password")
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @OneToMany(mappedBy = "owner")
    public Set<BillingDetail> getBillingDetail() {
        return this.billingDetail;
    }

    public void setBillingDetail(Set<BillingDetail> billingDetail) {
        this.billingDetail = billingDetail;
    }
}

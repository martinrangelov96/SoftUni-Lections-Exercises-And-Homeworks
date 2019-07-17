package panda.domain.models.binding;

import panda.domain.entities.Package;
import panda.domain.entities.User;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ReceiptCreateBindingModel {

    private BigDecimal fee;
    private LocalDateTime issuedOn;
    private String recipient;
    private String aPackage;

    public ReceiptCreateBindingModel() {
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    public LocalDateTime getIssuedOn() {
        return issuedOn;
    }

    public void setIssuedOn(LocalDateTime issuedOn) {
        this.issuedOn = issuedOn;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getaPackage() {
        return aPackage;
    }

    public void setaPackage(String aPackage) {
        this.aPackage = aPackage;
    }
}

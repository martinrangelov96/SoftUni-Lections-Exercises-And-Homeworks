package panda.domain.models.view;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ReceiptViewModel {

    private String id;
    private BigDecimal fee;
    private LocalDateTime issuedOn;
    private String recipient;
    private String aPackage;

    public ReceiptViewModel() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

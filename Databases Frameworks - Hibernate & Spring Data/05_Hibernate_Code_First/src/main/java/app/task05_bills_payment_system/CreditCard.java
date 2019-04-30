package app.task05_bills_payment_system;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "credit_cards")
public class CreditCard extends BillingDetail{

    private String cardType;
    private Integer expirationMonth;
    private Integer expirationYear;

    public CreditCard() {
    }

    @Column(name = "card_type")
    public String getCardType() {
        return this.cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    @Column(name = "expiration_month")
    public Integer getExpirationMonth() {
        return this.expirationMonth;
    }

    public void setExpirationMonth(Integer expirationMonth) {
        this.expirationMonth = expirationMonth;
    }

    @Column(name = "expiration_year")
    public Integer getExpirationYear() {
        return this.expirationYear;
    }

    public void setExpirationYear(Integer expirationYear) {
        this.expirationYear = expirationYear;
    }
}

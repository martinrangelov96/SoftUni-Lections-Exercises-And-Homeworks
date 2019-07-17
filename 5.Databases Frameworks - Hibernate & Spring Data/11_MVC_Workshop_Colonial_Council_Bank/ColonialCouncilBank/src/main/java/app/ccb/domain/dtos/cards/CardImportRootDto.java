package app.ccb.domain.dtos.cards;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "cards")
@XmlAccessorType(XmlAccessType.FIELD)
public class CardImportRootDto {

    @XmlElement(name = "card")
    private CardImportDto[] cardImportDtos;

    public CardImportRootDto() {
    }

    public CardImportDto[] getCardImportDtos() {
        return cardImportDtos;
    }

    public void setCardImportDtos(CardImportDto[] cardImportDtos) {
        this.cardImportDtos = cardImportDtos;
    }
}

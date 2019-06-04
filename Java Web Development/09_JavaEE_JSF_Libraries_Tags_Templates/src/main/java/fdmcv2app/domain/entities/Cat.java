package fdmcv2app.domain.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity(name = "cats")
public class Cat extends BaseEntity {

    private String name;
    private String breed;
    private String color;
    private Integer age;
    private String gender;
    private BigDecimal price;
    private Date addedOn;
    private Boolean hasPassport;

    public Cat() {
    }

    @NotNull
    @Column(name = "name")
    @Size(min = 2, max = 10)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NotNull
    @Column(name = "breed")
    @Size(min = 5, max = 20)
    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    @NotNull
    @Column(name = "color")
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @NotNull
    @Column(name = "age")
    @Min(1)
    @Max(31)
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @NotNull
    @Column(name = "gender")
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @NotNull
    @Column(name = "price")
    @DecimalMin("0.1")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @NotNull
    @Column(name = "added_on")
    public Date getAddedOn() {
        return addedOn;
    }

    public void setAddedOn(Date addedOn) {
        this.addedOn = addedOn;
    }

    @Column(name = "has_passport")
    public Boolean getHasPassport() {
        return hasPassport;
    }

    public void setHasPassport(Boolean hasPassport) {
        this.hasPassport = hasPassport;
    }
}

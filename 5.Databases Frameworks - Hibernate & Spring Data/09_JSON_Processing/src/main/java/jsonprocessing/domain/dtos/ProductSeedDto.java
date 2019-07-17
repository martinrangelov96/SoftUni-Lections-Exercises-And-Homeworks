package jsonprocessing.domain.dtos;

import com.google.gson.annotations.Expose;

import javax.validation.constraints.*;
import java.math.BigDecimal;

public class ProductSeedDto {

    @Expose
    private String name;

    @Expose
    private BigDecimal price;

    public ProductSeedDto() {
    }

    @NotNull(message = "Product name cannot be null.")
    @Size(min = 3, message = "Product name must be at least 3 symbols long.")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NotNull(message = "Product price cannot be null.")
    @Positive(message = "Price must be positive number.")
    @DecimalMin(value = "0.01", message = "Product price must be at least 0.01")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}

package jsonprocessing.domain.dtos;

import com.google.gson.annotations.Expose;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CategorySeedDto {

    @Expose
    private String name;

    public CategorySeedDto() {
    }

    @NotNull(message = "Category name cannot be null.")
    @Size(min = 3, max = 15, message = "Category name must be between 3 and 15 symbols.")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

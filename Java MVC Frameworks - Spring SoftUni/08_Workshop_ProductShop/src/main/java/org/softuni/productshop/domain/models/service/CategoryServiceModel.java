package org.softuni.productshop.domain.models.service;

public class CategoryServiceModel extends BaseServiceModel {

    private String id;
    private String name;

    public CategoryServiceModel() {
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

package org.softuni.residentevil.web.domain.models.service;

public class RoleServiceModel {

    private String id;
    private String authority;

    public RoleServiceModel() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}

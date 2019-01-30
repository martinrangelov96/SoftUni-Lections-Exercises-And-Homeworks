package homework03_google;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private Company company;
    private Car car;
    private List<Parents> parents;
    private List<Children> children;
    private List<Pokemon> pokemons;

    public Person(String name) {
        this.name = name;
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
        this.pokemons = new ArrayList<>();
    }

    public Person(String name, Company company) {
        this.name = name;
        this.company = company;
    }

    public Person(String name, Car car) {
        this.name = name;
        this.car = car;
    }

    public String getName() {
        return this.name;
    }

    public Company getCompany() {
        return this.company;
    }

    public Car getCar() {
        return this.car;
    }

    public List<Parents> getParents() {
        return this.parents;
    }

    public List<Children> getChildren() {
        return this.children;
    }

    public List<Pokemon> getPokemons() {
        return this.pokemons;
    }
}

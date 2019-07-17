package jsonprocessing.domain.entities;

import javax.persistence.*;
import java.util.List;

@Entity(name = "users")
public class User extends BaseEntity {

    private String firstName;
    private String lastName;
    private Integer age;
    private List<User> friends;

    private List<Product> productsForSale;
    private List<Product> productsForBuy;

    public User() {
    }

    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "last_name", nullable = false)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "age")
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @ManyToMany(targetEntity = User.class)
    @JoinTable(
            name = "users_friends",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "friend_id", referencedColumnName = "id")
    )
    public List<User> getFriends() {
        return friends;
    }

    public void setFriends(List<User> friends) {
        this.friends = friends;
    }

    @OneToMany(mappedBy = "buyer")
    public List<Product> getProductsForSale() {
        return productsForSale;
    }

    public void setProductsForSale(List<Product> productsForSale) {
        this.productsForSale = productsForSale;
    }

    @OneToMany(mappedBy = "seller")
    public List<Product> getProductsForBuy() {
        return productsForBuy;
    }

    public void setProductsForBuy(List<Product> productsForBuy) {
        this.productsForBuy = productsForBuy;
    }
}

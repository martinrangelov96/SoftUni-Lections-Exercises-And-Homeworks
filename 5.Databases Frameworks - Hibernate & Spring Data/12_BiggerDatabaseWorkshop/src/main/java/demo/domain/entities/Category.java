package demo.domain.entities;

import demo.domain.entities.base.BaseEntity;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "categories")
public class Category extends BaseEntity {

    private String name;
    private Category parentCategory;
    private Set<Category> subcategories;
    private Set<Contest> contests;

    public Category() {
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    @ManyToOne(targetEntity = Category.class)
    @JoinColumn(
            name = "category_id", referencedColumnName = "id"
    )
    public Category getParentCategory() {
        return parentCategory;
    }

    @OneToMany(targetEntity = Category.class, mappedBy = "parentCategory")
    public Set<Category> getSubcategories() {
        return subcategories;
    }

    @OneToMany(targetEntity = Contest.class, mappedBy = "category")
    public Set<Contest> getContests() {
        return contests;
    }

    //


    public void setName(String name) {
        this.name = name;
    }

    public void setParentCategory(Category parentCategory) {
        this.parentCategory = parentCategory;
    }

    public void setSubcategories(Set<Category> subcategories) {
        this.subcategories = subcategories;
    }

    public void setContests(Set<Contest> contests) {
        this.contests = contests;
    }
}

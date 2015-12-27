package com.mbrull.persistence.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false, unique = true)
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category", orphanRemoval = true)
    private Set<Subcategory> subcategories = new HashSet<Subcategory>();

    protected Category() {
    }

    public Category(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Category(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Subcategory> getSubcategories() {
        return subcategories;
    }

    public void setSubcategories(Set<Subcategory> subcategories) {
        this.subcategories = subcategories;
        for (Subcategory sub : subcategories) {
            sub.setCategory(this);
        }
    }

    public void addSubcategory(Subcategory subcategory) {
        this.subcategories.add(subcategory);
        subcategory.setCategory(this);
    }

    public void removeSubcategory(Subcategory subcategory) {
        subcategory.setCategory(null);
        this.subcategories.remove(subcategory);
    }

}

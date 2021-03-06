package com.mbrull.persistence.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(nullable = false, length = 255)
    private String name;
    @Column(nullable = false, precision = 3)
    private float cost;
    @Temporal(TemporalType.DATE)
    private Date date;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_fk", nullable = false, insertable = false, updatable = false)
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_fk", nullable = false, insertable = false, updatable = false)
    private Category category;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "subcategory_fk", insertable = false, updatable = false)
    private Subcategory subcategory;

    protected Expense() {
    }

    public Expense(long id, String name, float cost, Date date, User user, Category category,
            Subcategory subcategory) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.date = date;
        this.user = user;
        this.category = category;
        this.subcategory = subcategory;
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

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Subcategory getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(Subcategory subcategory) {
        this.subcategory = subcategory;
    }

}

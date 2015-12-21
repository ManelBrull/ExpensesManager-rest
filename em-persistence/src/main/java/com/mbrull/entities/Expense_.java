package com.mbrull.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Expense.class)
public abstract class Expense_ {

	public static volatile SingularAttribute<Expense, Float> cost;
	public static volatile SingularAttribute<Expense, String> name;
	public static volatile SingularAttribute<Expense, Date> dateExpense;
	public static volatile SingularAttribute<Expense, Long> id;
	public static volatile SingularAttribute<Expense, Category> category;
	public static volatile SingularAttribute<Expense, SubCategory> subcategory;
	public static volatile SingularAttribute<Expense, User> user;

}


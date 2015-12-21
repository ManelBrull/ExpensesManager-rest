package com.mbrull.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(SubCategory.class)
public abstract class SubCategory_ {

	public static volatile SingularAttribute<SubCategory, String> name;
	public static volatile SingularAttribute<SubCategory, Long> id;
	public static volatile SingularAttribute<SubCategory, Category> category;

}


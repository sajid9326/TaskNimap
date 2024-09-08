package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer category_Id;
	private String category_Name;
	private String category_Type;
	@OneToMany(mappedBy = "productId")
	private List<Product> product=new ArrayList<>();


	public Category(Integer category_Id, String category_Name, String category_Type) {
		super();
		this.category_Id = category_Id;
		this.category_Name = category_Name;
		this.category_Type = category_Type;
	}

	@Override
	public String toString() {
		return "Category [category_Id=" + category_Id + ", category_Name=" + category_Name + ", category_Type="
				+ category_Type  + "]";
	}

	public Integer getCategory_Id() {
		return category_Id;
	}

	public void setCategory_Id(Integer category_Id) {
		this.category_Id = category_Id;
	}

	public String getCategory_Name() {
		return category_Name;
	}

	public void setCategory_Name(String category_Name) {
		this.category_Name = category_Name;
	}

	public String getCategory_Type() {
		return category_Type;
	}

	public void setCategory_Type(String category_Type) {
		this.category_Type = category_Type;
	}

}

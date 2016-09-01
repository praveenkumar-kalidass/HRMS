package com.i2i.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.i2i.model.Department;


/**
 * Model class for Designation
 * Setter and Getter methods for the class variables
 * Many to One mapping is established for department model class
 * 
 * @author Praveen RaJ
 * 
 * @created 2016-09-01
 */


@Entity
@Table(name="designation")
public class Designation {
    
	@Id
	@GeneratedValue(generator="increment")	
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private int name;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "department_id")
	private Department department;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getName() {
		return name;
	}

	public void setName(int name) {
		this.name = name;
	}

	public Department getDepartment_id() {
		return department;
	}

	public void setDepartment_id(Department department) {
		this.department = department;
	}	
}

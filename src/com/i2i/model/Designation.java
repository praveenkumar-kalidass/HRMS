package com.i2i.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.i2i.model.Department;

/**
 * Model class which stores the details associated with the Designations within each department in the company.
 * Many to One mapping is established for department model class.
 * 
 * @author Praveen RaJ
 * 
 * @created 2016-09-01
 */
@Entity
@Table(name="designation")
public class Designation {
    
	@Id
	@Column(name="id")
	private int designationId;
	
	@Column(name="name")
	private String designationName;
	
	@ManyToOne(cascade = CascadeType.PERSIST, fetch=FetchType.EAGER)
    @JoinColumn(name = "department_id" , nullable=false)
	@LazyCollection(LazyCollectionOption.FALSE)
	private Department department;

	public Designation(){	
	}
	
	public int getDesignationId() {
		return designationId;
	}

	public void setDesignationId(int designationId) {
		this.designationId = designationId;
	}

	public String getDesignationName() {
		return designationName;
	}

	public void setDesignationName(String designationName) {
		this.designationName = designationName;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}	
}

package com.i2i.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * <p>
 * Model class which stores the details associated with the
 * Department of the company.
 * </p>
 * 
 * @author Praveenkumar
 * 
 * @created 2016-09-01
 *
 */
@Entity
@Table(name = "department")
public class Department {
    @Id
    @GeneratedValue(generator="increment")
    @Column(name = "id", unique = true)
    private int departmentId;
    @Column(name = "name")
    private String departmentName;

    public Department(int departmentId, String departmentName) {
    	this.departmentId = departmentId;
    	this.departmentName = departmentName;
    }
    
    public Department() {
    }

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
}
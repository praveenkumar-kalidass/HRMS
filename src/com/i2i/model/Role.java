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
@Table(name = "role")
public class Role {
	@Id
    @Column(name = "id", unique = true)
    private int roleId;
    @Column(name = "name")
    private String roleName;
    
    public Role(int roleId, String roleName) {
    	this.roleId = roleId;
    	this.roleName = roleName;
    }
    
    public Role() {
    }

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
}
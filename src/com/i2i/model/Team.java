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

/**
 * <p>
 * Model class which stores the details associated with the Team of a project.
 * </p>
 * 
 * @author Praveenkumar
 * 
 * @created 2016-09-09
 */
@Entity
@Table(name = "team")
public class Team {
	@Id
	@Column(name = "id", unique = true)
	private int teamId;
	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinColumn(name = "project_id", nullable = false)
	@LazyCollection(LazyCollectionOption.FALSE)
	private Project project;
	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinColumn(name = "employee_id", nullable = false)
	@LazyCollection(LazyCollectionOption.FALSE)
	private Employee employee;
	@Column(name = "role")
	private String teamRole;

	public int getTeamId() {
		return teamId;
	}

	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public String getTeamRole() {
		return teamRole;
	}

	public void setTeamRole(String teamRole) {
		this.teamRole = teamRole;
	}
}
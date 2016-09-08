package com.i2i.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * <p>
 * Model class which stores the details associated with the Certification
 * details(s) of the employee.
 * </p>
 * 
 * @author Praveen RaJ
 * 
 * @created 2016-09-06
 *
 */

@Entity
@Table(name = "certification")
public class Certification {

	@Id
	@Column(name = "id", unique = true)
	private int certificationId;

	@Column(name = "from_date")
	private String fromDate;

	@Column(name = "to_date")
	private String toDate;

	@Column(name = "course_name")
	private String courseName;

	@Column(name = "institution")
	private String institution;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "employee_id")
	private Employee employee;

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getInstitution() {
		return institution;
	}

	public void setInstitution(String institution) {
		this.institution = institution;
	}

	public int getCertificationId() {
		return certificationId;
	}

	public void setCertificationId(int certificationId) {
		this.certificationId = certificationId;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}

package com.i2i.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Model class for Attendance
 * Setter and Getter methods for the class variables
 * Many to One mapping is established for Employee model class
 * 
 * @author Praveenkumar
 * 
 * @created 2016-09-07
 */
@Entity
@Table(name="attendance")
public class Attendance {
	@Id
	@GeneratedValue
	@Column(name="id")
	private int attendanceId;
	@Column(name="date")
	private String date;
	@Column(name="time_in")
	private String timeIn;
	@Column(name="time_out")
	private String timeOut;
	@ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "employee_id")
    private Employee employee;
	
	public int getAttendanceId() {
		return attendanceId;
	}
	public void setAttendanceId(int attendanceId) {
		this.attendanceId = attendanceId;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTimeIn() {
		return timeIn;
	}
	public void setTimeIn(String timeIn) {
		this.timeIn = timeIn;
	}
	public String getTimeOut() {
		return timeOut;
	}
	public void setTimeOut(String timeOut) {
		this.timeOut = timeOut;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
}
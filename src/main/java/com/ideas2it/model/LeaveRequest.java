package com.ideas2it.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

/**
 * Model class for Leave request Setter and Getter methods for the class
 * variables Many to One mapping is established for Employee model class
 * 
 * @author Praveenkumar
 * 
 * @created 2016-09-07
 */
@Entity
@Table(name = "leaverequest")
public class LeaveRequest {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int leaveId;
	@Column(name = "from_date")
	private String leaveFromDate;
	@Column(name = "to_date")
	private String leaveToDate;
	@Column(name = "reason")
	private String leaveReason;
	@Column(name = "status")
	private String leaveStatus;
	@Column(name = "no_days")
	private int noDays;
	@ManyToOne(fetch = FetchType.EAGER)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(name = "user_id", updatable = true, nullable = true)
	private User user;

	public LeaveRequest() {

	}

	public int getLeaveId() {
		return leaveId;
	}

	public void setLeaveId(int leaveId) {
		this.leaveId = leaveId;
	}

	public String getLeaveFromDate() {
		return leaveFromDate;
	}

	public void setLeaveFromDate(String leaveFromDate) {
		this.leaveFromDate = leaveFromDate;
	}

	public String getLeaveToDate() {
		return leaveToDate;
	}

	public void setLeaveToDate(String leaveToDate) {
		this.leaveToDate = leaveToDate;
	}

	public String getLeaveReason() {
		return leaveReason;
	}

	public void setLeaveReason(String leaveReason) {
		this.leaveReason = leaveReason;
	}

	public String getLeaveStatus() {
		return leaveStatus;
	}

	public void setLeaveStatus(String leaveStatus) {
		this.leaveStatus = leaveStatus;
	}

	public int getNoDays() {
		return noDays;
	}

	public void setNoDays(int noDays) {
		this.noDays = noDays;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}

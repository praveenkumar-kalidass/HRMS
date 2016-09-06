package com.i2i.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * <p>
 * Model class which stores the details associated with the
 * education detail(s) of the employee.
 * </p>
 * 
 * @author Praveen RaJ 
 * 
 * @created 2016-09-06
 *
 */

@Entity
@Table(name="education")
public class Education {
    @Id
    @Column(name="id", unique=true)
	private int id;
    
    @Column(name="from_date")
    private String fromDate;
    
    @Column(name="to_date")
    private String toDate;
    
    @Column(name="qualification")
    private String qualification;
    
    @Column(name="institution")
    private String institution;
    
    @Column(name="percentage")
    private String percentage;

	@Column(name="board")
    private String board;
    
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getInstitution() {
		return institution;
	}

	public void setInstitution(String institution) {
		this.institution = institution;
	}

	public String getPercentage() {
		return percentage;
	}

	public void setPercentage(String percentage) {
		this.percentage = percentage;
	}

	public String getBoard() {
		return board;
	}

	public void setBoard(String board) {
		this.board = board;
	}
}

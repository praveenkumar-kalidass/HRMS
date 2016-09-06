package com.i2i.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * <p>
 * Model class which stores the details associated with the
 * Certification details(s) of the employee.
 * </p>
 * 
 * @author Praveen RaJ 
 * 
 * @created 2016-09-06
 *
 */

@Entity
@Table(name="certification")
public class Certification {

	 @Id
	    @Column(name="id", unique=true)
		private int id;
	    
	    @Column(name="from_date")
	    private String fromDate;
	    
	    @Column(name="to_date")
	    private String toDate;
	    
	    @Column(name="course_name")
	    private String courseName;
	    
	    @Column(name="institution")
	    private String institution;

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
}

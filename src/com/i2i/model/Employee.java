package com.i2i.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 * <p>
 * Model class which stores the details associated with the
 * Employee of the company.
 * </p>
 * 
 * @author Praveenkumar
 * 
 * @created 2016-09-02
 *
 */
@Entity
@Table(name = "employee")
public class Employee {
	@Id
	@GeneratedValue
    @Column(name = "id", unique = true)
    private int employeeId;
	
	@Column(name = "firstname")
    private String employeeFirstName;
	
	@Column(name = "lastname")
    private String employeeLastName;
	
	@Column(name = "dob")
    private String employeeDateOfBirth;
	
	@Column(name = "gender")
    private String employeeGender;
	
	@Column(name = "maritalstatus")
    private String employeeMaritalStatus;
	
	@Column(name = "doj")
    private String employeeDateOfJoining;
	
	@Column(name = "picture")
    private String employeePicture;
	
	@Column(name = "username")
    private String employeeUserName;
	
	@Column(name = "password")
    private String employeePassword;
	
	@Column(name = "accountnumber")
    private String employeeBankAccountNumber;
	
	@Column(name = "basicpay")
    private String employeeBasicPay;
	
	@ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "designation_id")
	@LazyCollection(LazyCollectionOption.FALSE)
    private Designation employeeDesignation;
	
	@ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "role_id")
	@LazyCollection(LazyCollectionOption.FALSE)
    private Role employeeRole;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(cascade = CascadeType.PERSIST, mappedBy = "addressId")
    private List<Address> addresses = new ArrayList<Address>();
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(cascade = CascadeType.PERSIST, mappedBy = "certificationId")
    private List<Certification> certification = new ArrayList<Certification>();
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(cascade = CascadeType.PERSIST, mappedBy = "educationId")
    private List<Education> education = new ArrayList<Education>();
	

	public Employee() {
	}
	
	public List<Certification> getCertification() {
		return certification;
	}

	public void setCertification(List<Certification> certification) {
		this.certification = certification;
	}

	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	
	public String getEmployeeFirstName() {
		return employeeFirstName;
	}
	
	public void setEmployeeFirstName(String employeeFirstName) {
		this.employeeFirstName = employeeFirstName;
	}
	
	public String getEmployeeLastName() {
		return employeeLastName;
	}
	
	public void setEmployeeLastName(String employeeLastName) {
		this.employeeLastName = employeeLastName;
	}
	
	public String getEmployeeDateOfBirth() {
		return employeeDateOfBirth;
	}
	
	public void setEmployeeDateOfBirth(String employeeDateOfBirth) {
		this.employeeDateOfBirth = employeeDateOfBirth;
	}
	
	public String getEmployeeGender() {
		return employeeGender;
	}
	
	public void setEmployeeGender(String employeeGender) {
		this.employeeGender = employeeGender;
	}
	
	public String getEmployeeMaritalStatus() {
		return employeeMaritalStatus;
	}
	
	public void setEmployeeMaritalStatus(String employeeMaritalStatus) {
		this.employeeMaritalStatus = employeeMaritalStatus;
	}
	
	public String getEmployeeDateOfJoining() {
		return employeeDateOfJoining;
	}
	
	public void setEmployeeDateOfJoining(String employeeDateOfJoining) {
		this.employeeDateOfJoining = employeeDateOfJoining;
	}
	
	public String getEmployeePicture() {
		return employeePicture;
	}
	
	public String getEmployeeBankAccountNumber() {
		return employeeBankAccountNumber;
	}

	public void setEmployeeBankAccountNumber(String employeeBankAccountNumber) {
		this.employeeBankAccountNumber = employeeBankAccountNumber;
	}

	public String getEmployeeBasicPay() {
		return employeeBasicPay;
	}

	public void setEmployeeBasicPay(String employeeBasicPay) {
		this.employeeBasicPay = employeeBasicPay;
	}

	public void setEmployeePicture(String employeePicture) {
		this.employeePicture = employeePicture;
	}
	
	public String getEmployeeUserName() {
		return employeeUserName;
	}
	
	public void setEmployeeUserName(String employeeUserName) {
		this.employeeUserName = employeeUserName;
	}
	
	public String getEmployeePassword() {
		return employeePassword;
	}
	
	public void setEmployeePassword(String employeePassword) {
		this.employeePassword = employeePassword;
	}
	
	public Designation getEmployeeDesignation() {
		return employeeDesignation;
	}
	
	public void setEmployeeDesignation(Designation employeeDesignation) {
		this.employeeDesignation = employeeDesignation;
	}
	
	public Role getEmployeeRole() {
		return employeeRole;
	}
	
	public void setEmployeeRole(Role employeeRole) {
		this.employeeRole = employeeRole;
	}
	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}
	
	public void add(Address address) {
	        this.addresses.add(address);
	}
	
	public void addCertification(Certification certification) {
        this.certification.add(certification);
    }
	
	public void addEducation(Education education) {
        this.education.add(education);
    }

	public List<Education> getEducation() {
		return education;
	}

	public void setEducation(List<Education> education) {
		this.education = education;
	}
}
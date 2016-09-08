package com.i2i.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.i2i.model.Employee;


/**
 * Model class for Address
 * Setter and Getter methods for the class variables
 * Many to One mapping is established for Employee model class
 * 
 * @author Praveenkumar
 * 
 * @created 2016-09-06
 */


@Entity
@Table(name="address")
public class Address {
    
	@Id
	@Column(name="id")
	private int addressId;
	
	@Column(name="street")
	private String street;
	
	@Column(name="city")
	private String city;

	@Column(name="state")
	private String state;

	@Column(name="country")
	private String country;

	@Column(name="pincode")
	private int pincode;

	@Column(name="phonenumber")
	private int phoneNumber;

	@Column(name="e_mail")
	private String eMail;

	@Column(name="type")
	private String addressType;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "employee_id")
	@LazyCollection(LazyCollectionOption.FALSE)
	private Employee employee;
	
	public Address() {
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public String getAddressType() {
		return addressType;
	}

	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
}

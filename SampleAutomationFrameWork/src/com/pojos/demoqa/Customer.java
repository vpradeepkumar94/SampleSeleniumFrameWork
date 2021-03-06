package com.pojos.demoqa;

import java.util.Date;

public class Customer {
	
	
	public void setTestCaseID(String testCaseID) {
		this.testCaseID = testCaseID;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setAge(int age) { 
		this.age = age;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public void setMobileNumber(String  number) {
		this.mobileNumber = mobileNumber;
	}
	public void setDateOfBirth(Date date) {
		this.dateOfBirth = date;
	}
	public void setHasVoterId(boolean hasVoterId) {
		this.hasVoterId = hasVoterId;
	}

	public String getTestCaseID() {
		return testCaseID;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public int getAge() {
		return age;
	}
	public String getGender() {
		return gender;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public boolean isHasVoterId() {
		return hasVoterId;
	}
	public String[] getHobby() {
		return hobby;
	}
	public void setHobby(String[] hobby) {
		this.hobby = hobby;
	}

	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	* Specify the Excel header columns here
	 */
	
	private String testCaseID;
	private String firstName;
	private String lastName;
	private  int age ;
	private String gender;
	private String mobileNumber;
	private Date dateOfBirth;
	private boolean hasVoterId;
	private String[] hobby ;
	private String country;
	
	@Override
	public String toString() {
	
		return "Customer{"+
				"testCaseID= " + testCaseID + 
		       ",firstName = " + firstName    +     
		       	",lastName = " + lastName +  
		       	",age = " + age +  
		        ",gender = " + gender + 
		       	",mobileNumber = " + mobileNumber + 
		       	",dateOfBirth = "+ dateOfBirth + 
		       	",hasVoterId = " +hasVoterId + 
		"}";
		}
 }
	


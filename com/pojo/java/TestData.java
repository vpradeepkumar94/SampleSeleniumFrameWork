/**
 * 
 */
package com.excel.java;

public class TestData {

 	public void setSno(String sno) {
		Sno = sno;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public void setAge(Double double1) {
		Age = double1;
	}
	public void setGender(Object object) {
		Gender = (String) object;
	}
	public void setMajor(boolean isMajor) {
		this.isMajor = isMajor;
	}
  
 private  String Sno;
 private  String  FirstName;
 private  Double Age;
 private  String Gender;
 private  boolean isMajor;
  

@Override
public String toString() {
	 return  "TestData{" +
			  "FirstName="+FirstName  +
			   ",Age = '" + Age  + '\'' + 
			   ",Gender= '" +Gender +  '\'' +
			   ",isMajor = '"+isMajor +  '\'' +
			   '}';
	}
}

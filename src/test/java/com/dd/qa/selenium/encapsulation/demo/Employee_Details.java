package com.dd.qa.selenium.encapsulation.demo;

public class Employee_Details {
     
	private String employee_name;
	private int ssn_num;
	private int employee_age;
	
	
	
	public String getEmployee_name() {
		return employee_name;
	}



	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}



	public int getSsn_num() {
		return ssn_num;
	}



	public void setSsn_num(int ssn_num) {
		this.ssn_num = ssn_num;
	}



	public int getEmployee_age() {
		return employee_age;
	}



	public void setEmployee_age(int employee_age) {
		this.employee_age = employee_age;
	}



	public static void main(String[] args) {
		
		Employee_Details emp = new Employee_Details();
		emp.setEmployee_name("Debarati Dey");
		emp.setSsn_num(990789123);
		emp.setEmployee_age(31);
	
		System.out.println(emp.getEmployee_name());
		System.out.println(emp.getSsn_num());
		System.out.println(emp.getEmployee_age());
		
		
		
	}

}

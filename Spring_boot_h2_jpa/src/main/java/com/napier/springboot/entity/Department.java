package com.napier.springboot.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
//if this table name is not given it will create a table with name of this file i.e., DepartmentDto defaultly

public class Department {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long departmentId;
	private String departmentName;
	private String departmentCode;

	public Department(long dId, String dName, String dCode) {
		super();
		this.departmentId = dId;
		this.departmentName = dName;
		this.departmentCode = dCode;
	}

	public Department() {
		super();
		//System.out.println("Default constructor called");
	}

	public long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(long departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getDepartmentCode() {
		return departmentCode;
	}

	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}
}

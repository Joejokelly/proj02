package com.example;

import java.util.Date;

public class Inventory {
	private String make;
	private String model;
	//private int total;
	private String regNo;
	private Date startDate;
	private Date endDate;
	
	public Inventory() {
		
	}
	
	public Inventory(String make, String model, String regNo) {
		super();
		this.make = make;
		this.model = model;
		//this.total = total;
		this.regNo = regNo;
		startDate = null;
		endDate = null;
	}
	
	
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	
	@Override
	public String toString() {
		if ((startDate == null) && (endDate == null)) {
			return "Inventory [make=" + make + ", model =" + model +  ", regNo =" + regNo + "]";
		}
		else {
		return "Inventory [make=" + make + ", model =" + model +  ", regNo =" + regNo + ", startDate=" + startDate + ", endDate=" + endDate + "]";
		}
	
	}


	public Date getStartDate() {
		return startDate;
	}


	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}


	public Date getEndDate() {
		return endDate;
	}


	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getRegNo() {
		return regNo;
	}

	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}
	
	
	
}

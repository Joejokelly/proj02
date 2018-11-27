package com.example.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.ws.ServiceMode;

import com.example.Inventory;

public class CarRentalService {

	public String bookCarRental(String make, String model, String regNo, Date startDate, Date endDate, List<Inventory> cars)  {
		boolean found=false;
		boolean invCheck=false;
		
		found=false;
		invCheck=false;
		
		System.out.println("Booking in Progesss...");
		System.out.println("Make :" + make +  " Model :" + model +  " RegNo :" + regNo );
		System.out.println("From Date :" + startDate + " End Date " + endDate);
		
		for (Inventory inventory : cars) {
		
			if (inventory.getMake().equals(make) && (inventory.getModel().equals(model)) && inventory.getRegNo().equals(regNo)) {
				System.out.println("Found Make " + inventory.getMake() +  " Model :" + inventory.getModel() + " regNo :" + inventory.getRegNo());
				
				//System.out.println(" Start Date " + inventory.getStartDate() +  " EndDate :" + inventory.getEndDate());
				if (inventory.getStartDate() == null && (inventory.getEndDate() == null)) {
					found = true;
					invCheck=true;
					inventory.setStartDate(startDate);
					inventory.setEndDate(endDate);
					//inventory.setTotal(inventory.getTotal() -1);
					break;
				}
					
				if ((startDate.equals(inventory.getEndDate())) || startDate.before(inventory.getEndDate())) {
					System.out.println("Booking not avaliable for Dates");
					found = false;
					invCheck = true;
					break;
				}
				
				if (startDate.after(inventory.getEndDate())) {
					found = true;
					invCheck=true;
					inventory.setStartDate(startDate);
					inventory.setEndDate(endDate);
					//inventory.setTotal(inventory.getTotal() -1);
					break;
				} //if
				
			} //if	
		
		} //for	

		 
		if (!invCheck) {
			return "Car Not Found in Inventory, Cannot Book";
		}
		else
		if (found) {
			return "Successfully booked!!!";
		}
		else {
			return "Not Avaliable for Dates, Please Choose another Date ";
		}
		
	
 } //method

} //class	
	
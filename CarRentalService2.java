package com.example.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.ws.ServiceMode;

import com.example.Inventory;



public class CarRentalService2 {

	public String bookCarRental(String make, String model, String regNo, Date startDate, Date endDate, List<Inventory> cars)  {
		//System.out.println("<< CarRentalService >>" );
		boolean found;
		
/*		for (Inventory i : cars) {
			System.out.println(i);
		}
*/		
		found=false;

		for (Inventory inventory : cars) {
		
			if (inventory.getMake().equals(make) && (inventory.getModel().equals(model)) && inventory.getRegNo().equals(regNo)) {
				System.out.println("Found Make " + inventory.getMake() +  " Model :" + inventory.getModel() + " regNo :" + inventory.getRegNo());
				
				//System.out.println(" Start Date " + inventory.getStartDate() +  " EndDate :" + inventory.getEndDate());
				if (inventory.getStartDate() == null && (inventory.getEndDate() == null)) {
					found = true;
					inventory.setStartDate(startDate);
					inventory.setEndDate(endDate);
					//inventory.setTotal(inventory.getTotal() -1);
					break;
				}
				
				if (startDate.before(inventory.getEndDate())) {
					System.out.println("Booking not avaliable for Dates");
					found = false;
					break;
				}
				
				if (startDate.after(inventory.getEndDate())) {
					found = true;
					inventory.setStartDate(startDate);
					inventory.setEndDate(endDate);
					//inventory.setTotal(inventory.getTotal() -1);
					break;
				} //if
				
			} //if	
		
		} //for	
			
		if (found) {
			return "Successfully booked!";
		}
		else {
			return "Cannot Book for dates";
		}
		
	
 } //method

} //class	
	
package com.example;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.example.service.CarRentalService;

public class BookCarRental {

	public static void main(String[] args) {
		List<Inventory> cars = Arrays.asList(
		new Inventory("Toyota", "Camry", "TC0001"),
		new Inventory("Toyota", "Camry", "TC0002"),
		new Inventory("Volvo", "S60", "VS6001"),
		new Inventory("Ford", "Focus", "FF0001"),
		new Inventory("Ford", "Focus", "FF0002")
		
		);
 		
		for (Inventory i : cars) {
			System.out.println("Inventory cars :" + i);
		}
		
		System.out.println("<-------------------------------------------->");
		CarRentalService carRentalService = new CarRentalService();
		
		
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

//1 - Begin //
		Date d1=null;
		Date d2=null;
		try {
		d1 = simpleDateFormat.parse("2018-10-26");
		d2 = simpleDateFormat.parse("2018-10-29");
		}
		catch (Exception ex) {
			System.out.println("exception " + ex);
		}
		
		String carBooked = carRentalService.bookCarRental("Toyota", "Camry", "TC0001", d1, d2, cars);
		System.out.println(carBooked);
		
/*		for (Inventory i : cars) {
			System.out.println(i);
		}
*/
		System.out.println("<-------------------------------------------->");
		
//2 - Begin //
		d1=null;
		d2=null;
		
		try {
		d1 = simpleDateFormat.parse("2018-10-29");
		d2 = simpleDateFormat.parse("2018-11-02");
		}
		catch (Exception ex) {
			System.out.println("exception " + ex);
		}
		
		carBooked = carRentalService.bookCarRental("Toyota", "Camry", "TC0001", d1, d2, cars);
		System.out.println(carBooked);
		
	/*	for (Inventory i : cars) {
			System.out.println(i);
		}
*/
		System.out.println("<-------------------------------------------->");

//3 - Begin //
				d1=null;
				d2=null;
				
				try {
				d1 = simpleDateFormat.parse("2018-10-29");
				d2 = simpleDateFormat.parse("2018-11-05");
				}
				catch (Exception ex) {
					System.out.println("exception " + ex);
				}

				carBooked = carRentalService.bookCarRental("Volvo", "S60", "VS6001", d1, d2, cars);
				System.out.println(carBooked);
/*				
				for (Inventory i : cars) {
					System.out.println(i);
				}
*/
				System.out.println("<-------------------------------------------->");

//4 - Begin Test Case not in inventory //
			d1=null;
			d2=null;
				
				try {
				d1 = simpleDateFormat.parse("2018-10-29");
				d2 = simpleDateFormat.parse("2018-11-02");
				}
				catch (Exception ex) {
					System.out.println("exception " + ex);
				}
				
				carBooked = carRentalService.bookCarRental("Toyotax", "Camryx", "TC0001", d1, d2, cars);
				System.out.println(carBooked);
							
	}

}

package com.shubham.rastogi;

import java.util.ArrayList;
import java.util.List;

import com.shubham.rastogi.dto.Car;
import com.shubham.rastogi.dto.SlotPrice;
import com.shubham.rastogi.dto.Vehicle;
import com.shubham.rastogi.service.FlipKarService;
import com.shubham.rastogi.service.FlipKarServiceImpl;

public class Main {

	public static void main(String[] args) {
		List<Vehicle> vehicles = new ArrayList<>();
		Vehicle c1 = new Vehicle("car1", "Car", false, false, false, false, new SlotPrice(10,"Morning"), new SlotPrice(10,"Afternnon"), new SlotPrice(10,"Evening"), new SlotPrice(10,"Night"));
		Vehicle c2 = new Vehicle("car2", "Car", false, false, false, false, new SlotPrice(10,"Morning"), new SlotPrice(10,"AfterNoon"), new SlotPrice(10,"Evening"), new SlotPrice(10,"Night"));
		Vehicle b1 = new Vehicle("bike1", "Bike", false, false, false, false, new SlotPrice(10,"Morning"), new SlotPrice(10,"AfterNoon"), new SlotPrice(10,"Evening"), new SlotPrice(10,"Night"));
		Vehicle b2 = new Vehicle("bike2", "Bike", false, false, false, false, new SlotPrice(10,"Morning"), new SlotPrice(10,"AfterNoon"), new SlotPrice(10,"Evening"), new SlotPrice(10,"Night"));
		
		
		vehicles.add(c1);
		vehicles.add(c2);
		vehicles.add(b1);
		vehicles.add(b2);
		
		
		
		//Function Data to pass along with vehicles (List of vehicles)
		String vehicleType = "";
		boolean sortByPrice = false;
		String filterByTimeSlots = "";
		
		
		FlipKarService service = new FlipKarServiceImpl();
		//Search Functions
		//service.search(vehicles);
		service.Search(vehicles,vehicleType,sortByPrice,filterByTimeSlots);
		
		
		//Function Data to pass alogn with vehicle (List Of Vehicles)
		String vehicleId="bike1";
		String slot="Morning";
		//booking Functions
		
		service.bookVehicle(vehicles,vehicleId,slot);
		service.Search(vehicles,vehicleType,sortByPrice,filterByTimeSlots);
		service.bookVehicle(vehicles,vehicleId,slot);
		
	}

}

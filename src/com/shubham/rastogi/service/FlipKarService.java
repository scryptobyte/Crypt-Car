package com.shubham.rastogi.service;

import java.util.List;

import com.shubham.rastogi.dto.Vehicle;

public interface FlipKarService {

	//void search(List<Vehicle> vehicles);

	void Search(List<Vehicle> vehicles, String vehicleType, boolean sortByPrice, String filterByTimeSlots);
	void bookVehicle(List<Vehicle> vehicles, String vehicleId, String slot);

}

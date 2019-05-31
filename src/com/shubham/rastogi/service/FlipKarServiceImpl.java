package com.shubham.rastogi.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.shubham.rastogi.dto.Vehicle;



public class FlipKarServiceImpl implements FlipKarService {

	@Override
	public void Search(List<Vehicle> vehicle, String vehicleType, boolean sortByPrice, String filterByTimeSlots) {
		List<Vehicle> vehicles = (List<Vehicle>) ((ArrayList) vehicle).clone();
		List<Vehicle> searchVehicles = new ArrayList<>();
		
		if(filterByTimeSlots!="") {
			if(filterByTimeSlots=="Morning") {
				for(Vehicle v:vehicles) {
					if(!v.isMorning())
						searchVehicles.add(v);
				}
			}
			if(filterByTimeSlots=="AfterNoon") {
				for(Vehicle v:vehicles) {
					if(!v.isAfternoon())
						searchVehicles.add(v);
				}
			}
			if(filterByTimeSlots=="Evening") {
				for(Vehicle v:vehicles) {
					if(!v.isEvening())
						searchVehicles.add(v);
				}
			}
			if(filterByTimeSlots=="Night") {
				for(Vehicle v:vehicles) {
					if(!v.isNight())
						searchVehicles.add(v);
				}
			}
		}else {
			for(Vehicle v : vehicles) {
				searchVehicles.add(v);
			}
		}
		
		if(vehicleType!="") {
			List<Vehicle> found = new ArrayList<>();
			for(Vehicle v : searchVehicles) {
				if(v.getVehicleType()!=vehicleType) {
					found.add(v);
				}
			}
			searchVehicles.removeAll(found);
		}
		if(sortByPrice) {
			searchVehicles.sort(new Comparator<Vehicle>() {

				@Override
				public int compare(Vehicle v1, Vehicle v2) {
					if(filterByTimeSlots=="") {
						if(v1.getMorningPrice().getPrice()==v2.getMorningPrice().getPrice()) {
							if(v1.getAfternoonPrice().getPrice()==v2.getAfternoonPrice().getPrice()) {
								if(v1.getEveningPrice()==v2.getEveningPrice()) {
									return v1.getNightPrice().getPrice()-v1.getNightPrice().getPrice();
								}else
									return v1.getEveningPrice().getPrice()-v2.getEveningPrice().getPrice();
							}else
								return v1.getAfternoonPrice().getPrice()-v2.getAfternoonPrice().getPrice();
						}else
							return v1.getMorningPrice().getPrice()-v2.getMorningPrice().getPrice();
					}else {
						if(filterByTimeSlots=="Morning")
							return v1.getMorningPrice().getPrice()-v2.getMorningPrice().getPrice();
						else if(filterByTimeSlots=="AfterNoon")
							return v1.getAfternoonPrice().getPrice()-v2.getAfternoonPrice().getPrice();
						else if(filterByTimeSlots=="Evening")
							return v1.getEveningPrice().getPrice()-v2.getEveningPrice().getPrice();
						else
							return v1.getNightPrice().getPrice()-v1.getNightPrice().getPrice();
					}
				}
			});
		}
		
		if(filterByTimeSlots=="") {
			for(Vehicle v:searchVehicles) {
				System.out.println(Vehicle.toPrintVehiclesWithoutSlots(v));
			}
		}else {
			for(Vehicle v:searchVehicles) {
				System.out.println(Vehicle.toPrintVehicles(v,filterByTimeSlots));
			}
		}
	}

	@Override
	public void bookVehicle(List<Vehicle> vehicle, String vehicleId,String slot) {
		//List<Vehicle> vehicles = (List<Vehicle>) ((ArrayList) vehicle).clone();
		Vehicle book = null;
		for(Vehicle v: vehicle) {
			if(v.getVehicleId()==vehicleId) {
				book=v;
				break;
			}
		}
		if(book==null) {
			System.out.println("Sorry this vehicle Id is not correct");
		}
		else{
			if(slot=="day") {
				if(!book.isMorning()||!book.isAfternoon()||!book.isEvening()||!book.isNight()) {
					if(!book.isMorning()) {
						System.out.println("Congo!! you have booked for Morning!!!");
					}
					if(!book.isAfternoon()) {
						System.out.println("Congo!! you have booked for AfterNoon!!!");
					}
					if(!book.isEvening()) {
						System.out.println("Congo!! you have booked for Eveingn!!!");
					}
					if(!book.isNight()) {
						System.out.println("Congo!! you have booked for Night!!!");
					}
					book.setEvening(true);
					book.setMorning(true);
					book.setNight(true);
					book.setAfternoon(true);
				}else {
					System.out.println("Vehicle not available for day");
				}
			}else {
				if(slot=="Morning") {
					if(!book.isMorning()) {
						System.out.println("Congo!! you have book vehicle for Morning!!!");
						book.setMorning(true);
					}else
						System.out.println("not available on this slot");
				}else if(slot=="AfterNoon") {
					if(!book.isAfternoon()) {
						System.out.println("Congo!! you have book vehicle for AfterNoon!!!");
						book.setAfternoon(true);
					}else
						System.out.println("not available on this slot");
				}else if(slot=="Evening") {
					if(!book.isEvening()) {
						System.out.println("Congo!! you have book vehicle for Eveingn!!!");
						book.setEvening(true);
					}else
						System.out.println("not available on this slot");
				}else {
					if(!book.isNight()) {
						System.out.println("Congo!! you have book vehicle for Night!!!");
						book.setNight(true);
					}else
						System.out.println("not available on this slot");
				}
					
			}
		}
	}
	
}

package com.shubham.rastogi.dto;

public class Car extends Vehicle{
	private String vehicleType;

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public Car(String vehicleId, String vehicleType, boolean morning, boolean afternoon, boolean evening, boolean night,
			SlotPrice morningPrice, SlotPrice afternoonPrice, SlotPrice eveningPrice, SlotPrice nightPrice,
			String vehicleType2) {
		super(vehicleId, vehicleType, morning, afternoon, evening, night, morningPrice, afternoonPrice, eveningPrice,
				nightPrice);
		vehicleType = vehicleType2;
	}
	
	
	
}

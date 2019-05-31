package com.shubham.rastogi.dto;

public class Vehicle {
	private String vehicleId;
	private String vehicleType;
	private boolean morning;
	private boolean afternoon;
	private boolean evening;
	private boolean night;
	private SlotPrice morningPrice;
	private SlotPrice afternoonPrice;
	private SlotPrice eveningPrice;
	private SlotPrice nightPrice;
	public String getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	public SlotPrice getMorningPrice() {
		return morningPrice;
	}
	public void setMorningPrice(SlotPrice morningPrice) {
		this.morningPrice = morningPrice;
	}
	public SlotPrice getAfternoonPrice() {
		return afternoonPrice;
	}
	public void setAfternoonPrice(SlotPrice afternoonPrice) {
		this.afternoonPrice = afternoonPrice;
	}
	public SlotPrice getEveningPrice() {
		return eveningPrice;
	}
	public void setEveningPrice(SlotPrice eveningPrice) {
		this.eveningPrice = eveningPrice;
	}
	public SlotPrice getNightPrice() {
		return nightPrice;
	}
	public void setNightPrice(SlotPrice nightPrice) {
		this.nightPrice = nightPrice;
	}
	public String getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(String vehicleId) {
		this.vehicleId = vehicleId;
	}
	public boolean isMorning() {
		return morning;
	}
	public void setMorning(boolean morning) {
		this.morning = morning;
	}
	public boolean isAfternoon() {
		return afternoon;
	}
	public void setAfternoon(boolean afternoon) {
		this.afternoon = afternoon;
	}
	public boolean isEvening() {
		return evening;
	}
	public void setEvening(boolean evening) {
		this.evening = evening;
	}
	public boolean isNight() {
		return night;
	}
	public void setNight(boolean night) {
		this.night = night;
	}
	public Vehicle(String vehicleId, String vehicleType, boolean morning, boolean afternoon, boolean evening,
			boolean night, SlotPrice morningPrice, SlotPrice afternoonPrice, SlotPrice eveningPrice,
			SlotPrice nightPrice) {
		this.vehicleId = vehicleId;
		this.vehicleType = vehicleType;
		this.morning = morning;
		this.afternoon = afternoon;
		this.evening = evening;
		this.night = night;
		this.morningPrice = morningPrice;
		this.afternoonPrice = afternoonPrice;
		this.eveningPrice = eveningPrice;
		this.nightPrice = nightPrice;
	}
	
	public static String toPrintVehiclesWithoutSlots(Vehicle v) {
		String str = "";
		
		if(!v.morning)
			str = str + v.getVehicleId()+"\t\t"+v.getVehicleType()+"\t\t"+v.getMorningPrice().getPrice()+"\t\tMorning\n";
		
		if(!v.afternoon)
			str = str + v.getVehicleId()+"\t\t"+v.getVehicleType()+"\t\t"+v.getAfternoonPrice().getPrice()+"\t\tAfterNoon\n";
		
		if(!v.evening)
			str = str + v.getVehicleId()+"\t\t"+v.getVehicleType()+"\t\t"+v.getEveningPrice().getPrice()+"\t\tEvening\n";
		
		if(!v.night)
			str = str + v.getVehicleId()+"\t\t"+v.getVehicleType()+"\t\t"+v.getNightPrice().getPrice()+"\t\tNight\n";
		
		return str;
	}
	public static String toPrintVehicles(Vehicle v,String daySlot){
		String str = "";
		if(daySlot=="Morning"&&!v.morning)
			str = str + v.getVehicleId()+"\t\t"+v.getVehicleType()+"\t\t"+v.getMorningPrice().getPrice()+"\t\tMorning\n";
		else if(daySlot=="AfterNoon"&&!v.afternoon)
			str = str + v.getVehicleId()+"\t\t"+v.getVehicleType()+"\t\t"+v.getAfternoonPrice().getPrice()+"\t\tAfterNoon\n";
		else if(daySlot=="Evening"&&!v.evening)
			str = str + v.getVehicleId()+"\t\t"+v.getVehicleType()+"\t\t"+v.getEveningPrice().getPrice()+"\t\tEvening\n";
		else if(daySlot=="Night"&&!v.night)
			str = str + v.getVehicleId()+"\t\t"+v.getVehicleType()+"\t\t"+v.getNightPrice().getPrice()+"\t\tNight\n";
		return str;
	}
}

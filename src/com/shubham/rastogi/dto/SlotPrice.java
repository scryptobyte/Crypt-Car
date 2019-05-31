package com.shubham.rastogi.dto;

public class SlotPrice extends Price {
	private String slotName;

	public String getSlotName() {
		return slotName;
	}

	public void setSlotName(String slotName) {
		this.slotName = slotName;
	}

	public SlotPrice(Integer price, String slotName) {
		super(price);
		this.slotName = slotName;
	}
}

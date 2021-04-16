package com.wolken.wolkenapp.garage_webservice_consumable.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class ConsumableGarageDTO {

	private int id;
	private String name;
	private double price;
	private String color;
	private int noOfWheels;

}

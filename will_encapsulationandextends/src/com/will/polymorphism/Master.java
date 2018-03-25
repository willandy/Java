package com.will.polymorphism;

public class Master {

	public void cure(Pet pet){
		if(pet.getHealth()<50){
			pet.toHospital();
		}
	}
	
}

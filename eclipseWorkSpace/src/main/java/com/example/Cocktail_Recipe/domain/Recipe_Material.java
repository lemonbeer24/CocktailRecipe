package com.example.Cocktail_Recipe.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Recipe_Material {

	private String MaterialName;
	private int volume;
	private String unit;
	
	/*
	public String getMaterialName() {
		return MaterialName;
	}
	public void setMaterialName(String materialName) {
		MaterialName = materialName;
	}
	public int getVolume() {
		return volume;
	}
	public void setVolume(int volume) {
		this.volume = volume;
	}
	*/

}

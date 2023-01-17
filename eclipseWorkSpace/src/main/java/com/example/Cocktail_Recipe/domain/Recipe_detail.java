package com.example.Cocktail_Recipe.domain;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Recipe_detail {

	private ArrayList<Recipe_Material> Materials;
	private ArrayList<Recipe_Procedure> procedures;
	private ArrayList<String> note;
	
}

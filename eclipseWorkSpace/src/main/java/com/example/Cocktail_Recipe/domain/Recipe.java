package com.example.Cocktail_Recipe.domain;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Recipe {
	
	//sql 에서 받아오는 필드들
	private long id;
	private String drinkName;
	private String drinkImgDirUUID;
	private Recipe_detail recipeDetail;

	//나중에 다른곳 에서 받아오는 필드들
	private String mainImgPath;
	private ArrayList<String> drinkImgsPath;
	
}

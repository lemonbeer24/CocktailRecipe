package com.example.Cocktail_Recipe.repository;

import java.util.List;
import java.util.Optional;

import com.example.Cocktail_Recipe.domain.Recipedummy;

public interface RecipeRepository {
	Optional<Recipedummy> findByid(long id);
	Optional<Recipedummy> findByidAndName(long id, String drinkName);
	List<Recipedummy> findAll();
	
	void createRecipe(String cockTailName, String UUID ,String json, String userid, String userpw);
	void UpdateRecipe(long id, String cockTailName ,String json);
	boolean AuthRecipe(long id, String userid, String userpw);
	void deleteRecipe(long id);
}

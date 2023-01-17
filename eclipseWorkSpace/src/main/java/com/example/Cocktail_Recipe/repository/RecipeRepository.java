package com.example.Cocktail_Recipe.repository;

import java.util.List;
import java.util.Optional;

import com.example.Cocktail_Recipe.domain.Recipe;

public interface RecipeRepository {
	Optional<Recipe> findByid(long id);
	Optional<Recipe> findByidAndName(long id, String drinkName);
	List<Recipe> findAll();
	
	void createRecipe(String cockTailName, String UUID ,String json, String userid, String userpw);
	void UpdateRecipe(long id, String cockTailName ,String json);
	boolean AuthRecipe(long id, String userid, String userpw);
	void deleteRecipe(long id);
}

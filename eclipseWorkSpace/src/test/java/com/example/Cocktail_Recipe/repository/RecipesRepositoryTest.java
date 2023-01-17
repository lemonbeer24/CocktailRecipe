package com.example.Cocktail_Recipe.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.example.Cocktail_Recipe.domain.Recipe;
import com.example.Cocktail_Recipe.domain.Recipe_Procedure;
import com.example.Cocktail_Recipe.service.ImageService;
import com.example.Cocktail_Recipe.service.RecipeService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
@Transactional
public class RecipesRepositoryTest {

	
	@Autowired RecipeRepository recipeRepository;
	@Autowired ImageService imageService;
	@Autowired RecipeService recipeService;
	
	/*
	@Test
	void RecipeAuthTest() 
	{
		boolean result = recipeRepository.AuthRecipe(32, "test", "123");
		
		if(result) { log.info("============= login ===============");}
	}
	
	@Test 
	void RecipeDeleteTest()
	{
		recipeRepository.deleteRecipe((long)30);
	}
	*/
	
	/*
	@Test
	void testFindByid() throws Exception {
		Recipe recipe = recipeRepository.findByid((long)1).get();
		System.out.println(recipe.getDrinkName());
	}
	
	@Test
	void testGetImgPath() throws Exception {
		Recipe recipe = recipeRepository.findByid((long) 1).get();
		ArrayList<String> ImagePaths = imageService.GetDrinkImgPath(recipe.getDrinkImgDirUUID(), recipe.getDrinkName());
		
		for (String string : ImagePaths) {
			System.out.println(string);
		}
	}
	
	@Test
	void testinitImgs() 
	{
		Recipe recipe = recipeService.FindRecipeToId(1);
		ArrayList<Recipe_Procedure> procedures = recipe.getRecipeDetail().getProcedures();
		log.info(recipe.getDrinkName());
		
		for (Recipe_Procedure recipe_Procedure : procedures) {
			String path = recipe_Procedure.getGuideImgPath();
			String name = recipe_Procedure.getGuideImgName();
			log.info("mix img path : " + path);
			log.info("name : " + name);
			if(path != null) 
			{
				log.info("mix img path : " + path);
			}
		}
	}
	*/

}

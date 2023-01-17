package com.example.Cocktail_Recipe;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.Cocktail_Recipe.repository.FileSystemImageRepository;
import com.example.Cocktail_Recipe.repository.ImageRepository;
import com.example.Cocktail_Recipe.repository.JdbcRecipeRepository;
import com.example.Cocktail_Recipe.repository.RecipeRepository;
import com.example.Cocktail_Recipe.service.ImageService;
import com.example.Cocktail_Recipe.service.RecipeService;

@Configuration
public class Springconfig {

	private final DataSource dataSource;
	
	public Springconfig(DataSource dataSource) 
	{
		this.dataSource = dataSource;
	}
	
	@Bean
	public ImageRepository imageRepository() 
	{
		return new FileSystemImageRepository();
	}
	
	@Bean
	public RecipeRepository recipeRepository() 
	{
		return new JdbcRecipeRepository(dataSource);
	}
	
	@Bean
	public RecipeService recipeService() 
	{
		return new RecipeService(recipeRepository(), imageService());
	}
	
	@Bean
	public ImageService imageService() 
	{
		return new ImageService();
	}
}

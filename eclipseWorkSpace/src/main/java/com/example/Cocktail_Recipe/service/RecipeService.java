package com.example.Cocktail_Recipe.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.example.Cocktail_Recipe.repository.RecipeRepository;

import lombok.extern.slf4j.Slf4j;

import com.example.Cocktail_Recipe.domain.Recipe;
import com.example.Cocktail_Recipe.domain.Recipe_Procedure;
import com.example.Cocktail_Recipe.domain.Recipe_detail;

@Slf4j
public class RecipeService {

	private final RecipeRepository recipeRepository;
	private final ImageService imageService;

	@Autowired
	public RecipeService(RecipeRepository repository, ImageService imageService) {
		this.recipeRepository = repository;
		this.imageService = imageService;
	}

	// Recipe 리스트 를 메인 페이지 의 테이블에 형식에 맟게 출력 할 수 있도록 리스트를 변형해 반환하는 메소드
	public List<List<Recipe>> FindRecipesTableFormat() {
		List<Recipe> Recipes = recipeRepository.findAll();

		for (Recipe recipe : Recipes) {
			initImgspaths(recipe);
		}

		List<List<Recipe>> tableRecipes = slideRecipes(Recipes, 4);
		return tableRecipes;
	}

	// 모든 레시피 반환
	public List<Recipe> FindRecipes() {
		List<Recipe> Recipes = recipeRepository.findAll();

		for (Recipe recipe : Recipes) {
			initImgspaths(recipe);
		}

		return Recipes;
	}

	// id(pk) 로 하나 찾기
	public Recipe FindRecipeToId(long id) {
		Recipe recipe = recipeRepository.findByid(id).get();
		initImgspaths(recipe);
		return recipe;
	}

	public Recipe FindRecipeToIdAndName(long id, String drinkName) {
		Recipe recipe = recipeRepository.findByidAndName(id, drinkName).get();
		initImgspaths(recipe);
		return recipe;
	}

	private void initImgspaths(Recipe recipe) {
		recipe.setDrinkImgsPath(imageService.GetDrinkImgPath(recipe.getDrinkImgDirUUID()));

		if (recipe.getDrinkImgsPath().size() > 0) {
			recipe.setMainImgPath(recipe.getDrinkImgsPath().get(0));
			log.info(recipe.getMainImgPath());
		}

		initProcedureImgpaths(recipe);
	}

	private void initProcedureImgpaths(Recipe recipe) {
		Recipe_detail detail = recipe.getRecipeDetail();

		if (detail != null) {
			ArrayList<Recipe_Procedure> procedures = recipe.getRecipeDetail().getProcedures();

			for (Recipe_Procedure recipe_Procedure : procedures) {
				if (recipe_Procedure.getGuideImgName() != null) {
					if (!recipe_Procedure.getGuideImgName().isEmpty()) {
						String path = imageService.GetProceduceImgPath(recipe.getDrinkImgDirUUID(),
								recipe_Procedure.getGuideImgName());
						log.info("path : " + path);

						recipe_Procedure.setGuideImgPath(path);
					}
				}
			}
		}
	}

	private List<List<Recipe>> slideRecipes(List<Recipe> list, int stackSize) {
		int listSize = list.size();
		int fullStack = listSize / stackSize;
		int restRecipe = listSize % stackSize;
		System.out.println("size : " + listSize + "full : " + fullStack + "rest : " + restRecipe);

		List<List<Recipe>> cont = new ArrayList<>();

		int lastindex = 0;
		for (int i = 1; i < fullStack + 1; i++) {
			System.out.println("for : " + i);
			List<Recipe> stack = list.subList(lastindex, (i * stackSize));
			for (Recipe recipe : stack) {
				System.out.println(recipe.getId());
			}
			System.out.println("start : " + lastindex + "end : " + i * stackSize);
			cont.add(stack);
			lastindex = i * stackSize;
		}

		List<Recipe> reststack = new ArrayList<Recipe>();

		for (int j = 0; j < restRecipe; j++) {
			System.out.println("last : " + lastindex);
			reststack.add(list.get(lastindex));
			lastindex++;
		}

		for (Recipe recipe : reststack) {
			System.out.println(recipe.getId());
		}

		cont.add(reststack);

		for (List<Recipe> recipe : cont) {
			System.out.println(recipe.size());
		}

		return cont;
	}
}

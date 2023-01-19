package com.example.Cocktail_Recipe.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.example.Cocktail_Recipe.repository.RecipeRepository;

import lombok.extern.slf4j.Slf4j;

import com.example.Cocktail_Recipe.domain.Recipedummy;
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
	public List<List<Recipedummy>> FindRecipesTableFormat() {
		List<Recipedummy> Recipes = recipeRepository.findAll();

		for (Recipedummy recipe : Recipes) {
			initImgspaths(recipe);
		}

		List<List<Recipedummy>> tableRecipes = slideRecipes(Recipes, 4);
		return tableRecipes;
	}

	// 모든 레시피 반환
	public List<Recipedummy> FindRecipes() {
		List<Recipedummy> Recipes = recipeRepository.findAll();

		for (Recipedummy recipe : Recipes) {
			initImgspaths(recipe);
		}

		return Recipes;
	}

	// id(pk) 로 하나 찾기
	public Recipedummy FindRecipeToId(long id) {
		Recipedummy recipe = recipeRepository.findByid(id).get();
		initImgspaths(recipe);
		return recipe;
	}

	public Recipedummy FindRecipeToIdAndName(long id, String drinkName) {
		Recipedummy recipe = recipeRepository.findByidAndName(id, drinkName).get();
		initImgspaths(recipe);
		return recipe;
	}

	private void initImgspaths(Recipedummy recipe) {
		recipe.setDrinkImgsPath(imageService.GetDrinkImgPath(recipe.getDrinkImgDirUUID()));

		if (recipe.getDrinkImgsPath().size() > 0) {
			recipe.setMainImgPath(recipe.getDrinkImgsPath().get(0));
			log.info(recipe.getMainImgPath());
		}

		initProcedureImgpaths(recipe);
	}

	private void initProcedureImgpaths(Recipedummy recipe) {
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

	private List<List<Recipedummy>> slideRecipes(List<Recipedummy> list, int stackSize) {
		int listSize = list.size();
		int fullStack = listSize / stackSize;
		int restRecipe = listSize % stackSize;
		System.out.println("size : " + listSize + "full : " + fullStack + "rest : " + restRecipe);

		List<List<Recipedummy>> cont = new ArrayList<>();

		int lastindex = 0;
		for (int i = 1; i < fullStack + 1; i++) {
			System.out.println("for : " + i);
			List<Recipedummy> stack = list.subList(lastindex, (i * stackSize));
			for (Recipedummy recipe : stack) {
				System.out.println(recipe.getId());
			}
			System.out.println("start : " + lastindex + "end : " + i * stackSize);
			cont.add(stack);
			lastindex = i * stackSize;
		}

		List<Recipedummy> reststack = new ArrayList<Recipedummy>();

		for (int j = 0; j < restRecipe; j++) {
			System.out.println("last : " + lastindex);
			reststack.add(list.get(lastindex));
			lastindex++;
		}

		for (Recipedummy recipe : reststack) {
			System.out.println(recipe.getId());
		}

		cont.add(reststack);

		for (List<Recipedummy> recipe : cont) {
			System.out.println(recipe.size());
		}

		return cont;
	}
}

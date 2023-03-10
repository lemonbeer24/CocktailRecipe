package com.example.Cocktail_Recipe.controller;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.core.io.Resource;

import com.example.Cocktail_Recipe.domain.FileDto;
import com.example.Cocktail_Recipe.domain.Recipedummy;
import com.example.Cocktail_Recipe.domain.Recipe_Material;
import com.example.Cocktail_Recipe.domain.Recipe_Procedure;
import com.example.Cocktail_Recipe.domain.Recipe_detail;
import com.example.Cocktail_Recipe.service.ImageService;
import com.example.Cocktail_Recipe.service.RecipeService;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class PageController {
	
	private final RecipeService recipeService;
	private final ImageService imageService;
	
	//@Value("${spring.servlet.multipart.location}")
	//String filePath;
	
	@Autowired
	public PageController(RecipeService recipeService, ImageService imageService) 
	{
		this.recipeService = recipeService;
		this.imageService = imageService;
	}
	
	@GetMapping("/")
	public String MainPageCont(Model model) 
	{
		List<List<Recipedummy>> tableRecipes = recipeService.FindRecipesTableFormat();
		//List<Recipe> tableRecipes = recipeService.FindRecipes();
		model.addAttribute("recipes", tableRecipes);
		return "mainPage.html";
	}
	
	@GetMapping("/upload")
	public String uploadform() 
	{
		return "file_upload";
	}
	
	@GetMapping(value = "/RecipeDetail")
	public String RecipeDetailPage(@RequestParam("name") String RecipeName, @RequestParam("id") long RecipeId, Model model) 
	{
		log.info("Recipe! name : " + RecipeName + "id : " + RecipeId);
		Recipedummy recipe = recipeService.FindRecipeToIdAndName(RecipeId, RecipeName);
		log.info("pathUUID : " + recipe.getDrinkImgDirUUID());
		model.addAttribute("recipe", recipe);
		
		for (String iterable_element : recipe.getDrinkImgsPath()) {
			log.info(iterable_element);
		}
		
		Recipe_detail detail = recipe.getRecipeDetail();
		ArrayList<Recipe_Material> materials = detail.getMaterials();
		ArrayList<Recipe_Procedure> procedures = detail.getProcedures();
		ArrayList<String> notes = detail.getNote();
		
		model.addAttribute("materials", materials);
		model.addAttribute("procedures", procedures);
		model.addAttribute("notes", notes);
		
		return "Recipe_detail";
	}
	
	//????????? ????????? ???????????? ???????????? ?????????, 
	@GetMapping("/result")
	public String uploadResult(Model model) 
	{
		List<Recipedummy> recipes = recipeService.FindRecipes();
		for (Recipedummy recipe : recipes) {
			recipe.setDrinkImgsPath(
					imageService.GetDrinkImgPath(recipe.getDrinkImgDirUUID()));
			if(recipe.getDrinkImgsPath().size() > 0) 
			{
				recipe.setMainImgPath(recipe.getDrinkImgsPath().get(0));
			}
		}
		
		for (Recipedummy recipe : recipes) {
			System.out.println(recipe.getDrinkName());
			for (String path : recipe.getDrinkImgsPath()) {
				System.out.println(path);
			}
		}
		
		model.addAttribute("recipes", recipes);
		return "file_result";
	}
	
	@ResponseBody
	@GetMapping("/sqlJsonTest")
	public String SqlJsonTest() 
	{
		Recipedummy recipe = recipeService.FindRecipeToId(1);
		Recipe_Procedure Pro = recipe.getRecipeDetail().getProcedures().get(0);
		return Pro.getProcedure();
	}
	
	/*
	@PostMapping("/upload")
	public String upload(@RequestParam MultipartFile[] uploadfile, Model model)
		throws IllegalStateException, IOException
	{
		List<FileDto> list = new ArrayList<>();
		
		for(MultipartFile file : uploadfile) 
		{
			log.info(String.valueOf(file.isEmpty()));
			if(!file.isEmpty()) 
			{
				//UUID??? ???????????? ????????? ?????? ????????? ???????????????.
				FileDto dto = new FileDto(UUID.randomUUID().toString(),
						file.getOriginalFilename(),
						file.getContentType());
				list.add(dto);
				
				File newFileName = new File(dto.getUuid() + "_" + dto.getFileName());
				file.transferTo(newFileName);
			}
		}
		for (FileDto fileDto : list) {
			log.info(fileDto.getFileName());
		}
		model.addAttribute("files", list);
		return "file_result";
	}
	
	@GetMapping("/download")
	public ResponseEntity<Resource> download(@ModelAttribute FileDto dto)
		throws IOException
	{
		Path path = Paths.get(filePath + "/" + dto.getUuid() + "_" + dto.getFileName());
		String contentType = Files.probeContentType(path);
		//header??? ????????? ???????????? ?????? ????????? ????????? ????????????.
		HttpHeaders headers = new HttpHeaders();
		headers.setContentDisposition(ContentDisposition.builder("attachment")
				.filename(dto.getFileName(), StandardCharsets.UTF_8).build());
		headers.add(HttpHeaders.CONTENT_TYPE, contentType);
		
		Resource resource = new InputStreamResource(Files.newInputStream(path));
		return new ResponseEntity<>(resource,headers,HttpStatus.OK);
	}
	*/

}

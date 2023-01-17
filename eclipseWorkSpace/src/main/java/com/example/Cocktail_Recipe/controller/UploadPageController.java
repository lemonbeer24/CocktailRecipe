package com.example.Cocktail_Recipe.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.Cocktail_Recipe.domain.ImageStatus;
import com.example.Cocktail_Recipe.domain.Recipe;
import com.example.Cocktail_Recipe.domain.Recipe_Material;
import com.example.Cocktail_Recipe.domain.Recipe_Procedure;
import com.example.Cocktail_Recipe.domain.Recipe_detail;
import com.example.Cocktail_Recipe.domain.Dto.ImageDto;
import com.example.Cocktail_Recipe.domain.Dto.MixprocessDto;
import com.example.Cocktail_Recipe.domain.Dto.RecipeDto;
import com.example.Cocktail_Recipe.repository.ImageRepository;
import com.example.Cocktail_Recipe.repository.RecipeRepository;
import com.example.Cocktail_Recipe.service.ImageService;
import com.example.Cocktail_Recipe.service.RecipeImageService;
import com.example.Cocktail_Recipe.service.RecipeJsonService;
import com.example.Cocktail_Recipe.service.RecipeService;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class UploadPageController {

	private final ImageService imageService;
	private final ImageRepository imageRepository;

	private final RecipeService recipeService;
	private final RecipeRepository recipeRepository;

	@Autowired
	private RecipeJsonService recipeJsonService;
	
	@Autowired
	private RecipeImageService recipeImageService;

	@Autowired
	public UploadPageController(ImageService imageService, ImageRepository imageRepository,
			RecipeRepository recipeRepository, RecipeService recipeService) {
		this.imageService = imageService;
		this.imageRepository = imageRepository;
		this.recipeRepository = recipeRepository;
		this.recipeService = recipeService;
	}

	@GetMapping("/RecipeUpload")
	public String entryRecipeUpload(Model model) {
		model.addAttribute("recipeDto", new RecipeDto());
		model.addAttribute("selecturl", "/RecipeUpload");
		return "RecipeUpload";
	}

	@PostMapping("/RecipeUpload")
	public String RecipeUpload(@ModelAttribute RecipeDto Dto) throws IllegalStateException, IOException {
		// 뭔가 MultipartFile 객체를 다룰 일 이 있다면 무조건 적 으로 IllegalStateException,
		// IOException 예외 처리 를 해야하는 듯.
		
		// 데이터 전처리 => json 생성 => sql 저장 => image 저장.
		// json 생성 과 이미지 파일 저장을 분리 해야함
		// 데이터 전처리는 json 생성 전 준비 되어야함.

		// 데이터 전처리 시작
		String name = Dto.getCocktailName();

		// 이름 마지막 문자 공백 검사
		String spaceCheck = String.valueOf(name.charAt(name.length() - 1));
		if (spaceCheck.isBlank()) {
			StringBuilder builder = new StringBuilder(name);
			name = String.valueOf(builder.deleteCharAt(builder.length() - 1));
		}

		// 데이터 전처리 종료

		// 필터링 된 이름을 dto 에 반영
		Dto.setCocktailName(name);

		// 폴더 이름에 넣을 UUID 생성
		String NewUUID = UUID.randomUUID().toString();

		// json 생성 과 이미지 파일 저장을 분리 해야함
		// 데이터 전처리는 json 생성 전 준비 되어야함.

		// json생성 및 sql 저장.
		String DetailStr = recipeJsonService.createDetailJson(Dto);
		recipeRepository.createRecipe(name, NewUUID, DetailStr, Dto.getUserid(), Dto.getUserpw());

		// 이미지 파일 저장
		// 칵테일 이미지 를 실제 폴더를 생성하고 그곳에 저장
		imageRepository.createRecipeDir(NewUUID, true);

		// 실제 칵테일 이미지 저장
		for (ImageDto imgdto : Dto.getCocktailImages()) {
			if(!imgdto.getFile().isEmpty()) {
				imageService.NewImageUpload(imgdto.getFile(),NewUUID, true);
			}
		}
		
		// 믹스 과정 이미지.
		// 믹스 과정 이미지 를 실제 폴더를 생성하고 그곳에 저장
		imageRepository.createRecipeDir(NewUUID, false);
		
		for (MixprocessDto Mixdto : Dto.getMixprocessList()) {
			if (!Mixdto.getMixImage().getFile().isEmpty()) {
				imageService.NewImageUpload
					(Mixdto.getMixImage().getFile(), NewUUID, false);
			}
		}
			
		return "redirect:/";

		// 필요한 동작...
		// 칵테일 이름, UUID, json 을 sql 로 업로드 해야함
		// sql 에 접근하니 repos 인터페이스 와 jdbcrepos 에 접근 해야함.
		// sql 를 만들을 전에 json 문자열 부터 만들어야함.
		// sql 에 저장하기 전에 이미지 저장이 재대로 됬는지 확인해야함 <- 완료

	}
	
	@PostMapping("/RecipeUpdateForm")
	public String entryRecipeUpdate(Model model, @RequestParam("id") Long id,
			@RequestParam("userid") String userid, @RequestParam("userpw") String userpw) {
		
		log.info("id : " + id);
		log.info("userid : " + userid);
		log.info("userpw : " + userpw);
		
		if(recipeRepository.AuthRecipe(id, userid, userpw)) {
			RecipeDto dto = RecipeDto.of(recipeService.FindRecipeToId((long)id));
			model.addAttribute("recipeDto", dto);
			model.addAttribute("selecturl", "/RecipeUpdate");
			return "RecipeUpload";
		}
		
		return "redirect:/";
	}
	
	@PostMapping("/RecipeUpdate")
	public String RecipeUpdate(@ModelAttribute RecipeDto Dto) throws IllegalStateException, IOException 
	{
		//DtoLoging(Dto);
		//모든 데이터 는 그냥 덮어쓰기 하면됨, but 그 전에 파일 시스템에 있는 이미지와
		//dto 로 넘어온 이미지를 비교하여 저장하거나 원래 이미지를 삭제하는 작업이 필요.
		
		Recipe recipe = recipeService.FindRecipeToId(Dto.getId());
		RecipeDto olddto = RecipeDto.of(recipe);
		
		log.info("================ cock image update ================");
		recipeImageService.UpdateImg(recipe.getDrinkImgDirUUID(),
				(ArrayList<ImageDto>)Dto.getCocktailImages(),
				(ArrayList<ImageDto>)olddto.getCocktailImages(),
				true);
		
		ArrayList<ImageDto> newmixs = new ArrayList<>();
		for(MixprocessDto mixs : Dto.getMixprocessList()) {
			newmixs.add(mixs.getMixImage());
		}
		
		ArrayList<ImageDto> oldmixs = new ArrayList<>();
		for(MixprocessDto mixs : olddto.getMixprocessList()) {
			oldmixs.add(mixs.getMixImage());
		}
		
		log.info("================ Mix image update ================");
		recipeImageService.UpdateImg(recipe.getDrinkImgDirUUID(),
				newmixs, oldmixs, false);
		
		String newDetail = recipeJsonService.createDetailJson(Dto);
		recipeRepository.UpdateRecipe(Dto.getId(), Dto.getCocktailName(), newDetail);
		
		return "redirect:/";
	}
	
	@PostMapping("/RecipeDelete")
	public String RecipeDeleteForm(@RequestParam("id") Long id, @RequestParam("userid") String userid,
			@RequestParam("userpw") String userpw) 
	{
		if(recipeRepository.AuthRecipe(id, userid, userpw)) 
		{
			String uuid = recipeService.FindRecipeToId(id).getDrinkImgDirUUID();
			imageRepository.DeleteAllRecipeDir(uuid);
			recipeRepository.deleteRecipe(id);
			return "redirect:/";
		}
		
		return "redirect:/RecipeUpload";
	}

	private void DtoLoging(RecipeDto Dto) 
	{
		log.info("cock name : " + Dto.getCocktailName());
		
		log.info("cock id : " + Dto.getId());

		log.info("cock img size : " + Dto.getCocktailImages().size());

		for (ImageDto filearr : Dto.getCocktailImages()) {
			if (filearr != null) {
				log.info("cockimageName : " + filearr.getImageFilename());
				log.info("multipartfileName : " + filearr.getFile().getOriginalFilename());
				log.info("cock img status : " + filearr.getImageStatus());
			}
		}

		// 레시피 디테일 영역--------
		log.info("name size : " + Dto.getMaterialnames().size());

		for (String string : Dto.getMaterialnames()) {
			log.info("name : " + string);
		}

		log.info("vols size : " + Dto.getVolumes().size());

		for (String string : Dto.getVolumes()) {
			log.info("vol : " + string);
		}

		for (String string : Dto.getNotes()) {
			log.info("note : " + string);
		}

		log.info("Mixprocesse size : " + Dto.getMixprocessList().size());

		for (MixprocessDto dto : Dto.getMixprocessList()) {
			log.info("Mixnote : " + dto.getProcessText());
			
			ImageDto img = dto.getMixImage();
			
			log.info("======= Miximgs =======");
			if (dto.getMixImage() != null) {
				log.info("cockimageName : " + img.getImageFilename());
				log.info("multipartfileName : " + img.getFile().getOriginalFilename());
				log.info("cock img status : " + img.getImageStatus());
			} else {
				log.info("======= img is null =======");
			}
		}
	}

}

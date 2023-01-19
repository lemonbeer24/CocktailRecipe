package com.example.Cocktail_Recipe.Dto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.Cocktail_Recipe.domain.ImageStatus;
import com.example.Cocktail_Recipe.domain.Recipedummy;
import com.example.Cocktail_Recipe.domain.Dto.ImageDto;
import com.example.Cocktail_Recipe.domain.Dto.MixprocessDto;
import com.example.Cocktail_Recipe.domain.Dto.RecipeDto;
import com.example.Cocktail_Recipe.service.ImageService;
import com.example.Cocktail_Recipe.service.RecipeService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class RecipeDtoTest {
	
	@Autowired
	private RecipeService recipeService;

	/*
	@Test
	void RecipeDtoOfTest() {
		Recipe recipe = recipeService.FindRecipeToId((long)28);
		RecipeDto Dto = RecipeDto.of(recipe);
		
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
		
		for (ImageDto cockImgname : Dto.getCocktailImages()) 
		{
			log.info("cockimgname =======> " + cockImgname.getImageFilename());
			log.info("cockimgstatus =======> " + cockImgname.getImageStatus());
		}

		log.info("Mixprocesse size : " + Dto.getMixprocessList().size());

		for (MixprocessDto dto : Dto.getMixprocessList()) {
			log.info("Mixnote : " + dto.getProcessText());

			if (dto.getMixImage() != null) {
				log.info("status : " + dto.getMixImage().getImageStatus());
				ImageDto img = dto.getMixImage();
				if (img.getImageStatus() == ImageStatus.New) {
					log.info("new Mix img ============> " + img.getFile().getOriginalFilename());
				}

				if (img.getImageStatus() == ImageStatus.Update || img.getImageStatus() == ImageStatus.NoUpdate) {
					log.info("Old Mix img ============> " + img.getImageFilename());
				}
			} else {
				log.info("======= img is null =======");
			}
		}
	}
	*/

}

package com.example.Cocktail_Recipe.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.multipart.MultipartFile;

import com.example.Cocktail_Recipe.domain.ImageStatus;
import com.example.Cocktail_Recipe.domain.Dto.ImageDto;
import com.example.Cocktail_Recipe.domain.Dto.RecipeDto;
import com.example.Cocktail_Recipe.service.RecipeImageService;
import com.example.Cocktail_Recipe.service.RecipeService;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@WebAppConfiguration
@Slf4j
class RecipeImageServiceTest {
	
	@Autowired
	private RecipeImageService recipeImageService;
	
	@Autowired
	private RecipeService recipeService;

	/*
	@Test
	void cockimgdeleteTest() throws FileNotFoundException, IOException {
		RecipeDto dto = RecipeDto.of(recipeService.FindRecipeToId((long)28));
		
		ArrayList<ImageDto> imgdtos =  (ArrayList<ImageDto>) dto.getCocktailImages();
		ArrayList<ImageDto> copyimgs = new ArrayList<>();
		
		for(ImageDto img : imgdtos) 
		{
			copyimgs.add(new ImageDto(null, img.getImageFilename(), img.getImageStatus()));
		}
		
		//더미파일 생성
		MultipartFile testimage1 = 
				new MockMultipartFile
				("test1","testimage1.jpg", "image/jpg" ,
						new FileInputStream(new File("C:/portfolioImages/testimage1.jpg")));
		
		MultipartFile testimage2 = 
				new MockMultipartFile("test2","testimage2.jpg", "image/jpg" ,
						new FileInputStream(new File("C:/portfolioImages/testimage2.jpg")));
		
		copyimgs.get(1).setFile(testimage1);
		copyimgs.get(1).setImageStatus(ImageStatus.Update);
		
		copyimgs.remove(2);
		
		ImageDto newimg = new ImageDto(testimage2, null, ImageStatus.New);
		copyimgs.add(newimg);
		
		
		log.info("befo imgs");
		for(ImageDto img : imgdtos) {
			log.info("name : " + img.getImageFilename());
			log.info("status : " + img.getImageStatus());
		}
		
		log.info("after imgs");
		for(ImageDto img : copyimgs) {
			log.info("name : " + img.getImageFilename());
			log.info("status : " + img.getImageStatus());
		}
		
		if(imgdtos.get(0) == copyimgs.get(0)) {
			log.info("same address!!!!!!!");
		}
		
		recipeImageService.UpdateImg("c0e6b7ec-21f9-439f-9a29-9b50e3a3c71f",
				copyimgs, imgdtos, true);
	}
	*/
}

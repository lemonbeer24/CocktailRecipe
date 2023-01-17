package com.example.Cocktail_Recipe.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.mockito.junit.MockitoJUnitRunner;

import com.example.Cocktail_Recipe.service.ImageService;

@SpringBootTest
@AutoConfigureMockMvc
class ImageRepositoryTest {

	@Autowired
	private ImageRepository imageRepository;
	
	@Autowired
	private ImageService imageService;
	
	/*
	@Test
	void imguploadtest() throws IllegalStateException, IOException 
	{
		MultipartFile testimage1 = 
				new MockMultipartFile
				("test1","testimage1.jpg", "image/jpg" ,
						new FileInputStream(new File("C:/portfolioImages/testimage1.jpg")));
		
		imageService.NewImageUpload(testimage1, "c0e6b7ec-21f9-439f-9a29-9b50e3a3c71f", true);
	}
	
	@Test
	void imgdirDeleteTest() {
		imageRepository.DeleteAllRecipeDir("554e9800-1dfe-415c-a668-8c230321e370");
	}
	*/

}

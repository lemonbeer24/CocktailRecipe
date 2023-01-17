package com.example.Cocktail_Recipe.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;

import com.example.Cocktail_Recipe.domain.FileDto;
import com.example.Cocktail_Recipe.domain.ImageStatus;
import com.example.Cocktail_Recipe.domain.Dto.ImageDto;
import com.example.Cocktail_Recipe.repository.ImageRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ImageService {
	
	@Autowired
	private ImageRepository imageRepository;
	
	public ArrayList<String> GetDrinkImgPath(String drinkImgUUID)
	{	 
		return imageRepository.GetDrinkImgsPath(drinkImgUUID);
	}
	
	public String GetProceduceImgPath(String drinkImgUUID, String ImgName)
	{	 
		return imageRepository.GetProcedureImgPath(ImgName, drinkImgUUID);
	}
	
	public void NewImageUpload(MultipartFile uploadfile, String UUID, boolean SaveDrinkImg) 
			throws IllegalStateException, IOException
	{
		imageRepository.uploadImg(uploadfile,SaveDrinkImg,UUID);
	}
	
	public void Imagedelete(String UUID, String fimgname, boolean delDrinkImg) 
	{
		imageRepository.Imagedelete(UUID, fimgname, delDrinkImg);
	}
	
	public int GetImageArrSize(ArrayList<MultipartFile[]> ImageArr) 
	{
		int size = 0;
		for (MultipartFile[] multipartFiles : ImageArr) {
			for(MultipartFile file : multipartFiles) 
			{
				if(!file.isEmpty()) {size++;}
			}
		}
		
		return size;
	}
	
}

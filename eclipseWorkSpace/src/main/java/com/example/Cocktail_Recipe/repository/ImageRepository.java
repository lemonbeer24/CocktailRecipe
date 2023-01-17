package com.example.Cocktail_Recipe.repository;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.web.multipart.MultipartFile;

public interface ImageRepository {
	public ArrayList<String> GetDrinkImgsPath(String DirPath);
	
	public String GetProcedureImgPath(String ImgName, String DirPath);
	
	public void uploadImg(MultipartFile image, boolean SaveDrinkImg, String RecipeUUID) 
			throws IllegalStateException, IOException;
	
	public void createRecipeDir(String RecipeUUID, boolean SaveDrinkImg);
	
	public void DeleteAllRecipeDir(String RecipeUUID);
	
	public void Imagedelete(String UUID, String fimgname, boolean SaveDrinkImg);
}

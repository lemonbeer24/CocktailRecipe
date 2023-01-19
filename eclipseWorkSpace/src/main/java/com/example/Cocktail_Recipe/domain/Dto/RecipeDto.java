package com.example.Cocktail_Recipe.domain.Dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.Cocktail_Recipe.domain.ImageStatus;
import com.example.Cocktail_Recipe.domain.Recipedummy;
import com.example.Cocktail_Recipe.domain.Recipe_Material;
import com.example.Cocktail_Recipe.domain.Recipe_Procedure;
import com.example.Cocktail_Recipe.domain.Recipe_detail;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RecipeDto {
	
	private long id;
	private String userid;
	private String userpw;
	
	private String cocktailName;
	
	private List<ImageDto> cocktailImages;
	
	private ArrayList<String> materialnames;
	private ArrayList<String> volumes;
	private ArrayList<String> units;
	
	private ArrayList<String> notes;
	
	private List<MixprocessDto> MixprocessList;
	
	public static RecipeDto of(Recipedummy recipe) 
	{
		//recipe 에서 dto 로 변환하는 것은 테이블 에서 데이터를 
		//가져 오는 것 을 전제로 한다.
		RecipeDto dto = new RecipeDto();
		
		dto.setId(recipe.getId());
		dto.setCocktailName(recipe.getDrinkName());
		
		//칵테일 이미지는 테이블 이나 json 에 저장된 게 아닌 폴더에만 유일하게 저장되어 있서
		//따로 폴더에서 내용을 읽고 저장하는 과정이 필요. => RecipeService 에서 처리
		//but 저장되어 있는 경로가 같이 추가되서 나옴 => 슬라이싱 필요
		
		ArrayList<ImageDto> imageDtos = new ArrayList<>();
		for(String imgname : recipe.getDrinkImgsPath()) 
		{
			ImageDto imgdto = new ImageDto();
			imgdto.setImageFilename(imgname.substring(47));
			imgdto.setImageStatus(ImageStatus.NoUpdate);
			imageDtos.add(imgdto);
		}
		dto.setCocktailImages(imageDtos);
		
		Recipe_detail detail = recipe.getRecipeDetail();
		
		ArrayList<Recipe_Material> materials = detail.getMaterials();
		ArrayList<String> materialnames = new ArrayList<>();
		ArrayList<String> volumes = new ArrayList<>();
		ArrayList<String> units = new ArrayList<>();
		
		for(Recipe_Material Material : materials) 
		{
			materialnames.add(Material.getMaterialName());
			volumes.add(Integer.toString(Material.getVolume()));
			units.add(Material.getUnit());
		}
		dto.setMaterialnames(materialnames);
		dto.setVolumes(volumes);
		dto.setUnits(units);
		
		ArrayList<Recipe_Procedure> procedures = detail.getProcedures();
		ArrayList<MixprocessDto> mixprocessDtos = new ArrayList<>();
		for(Recipe_Procedure procedure : procedures) 
		{
			MixprocessDto Mixdto = new MixprocessDto();
			ImageDto img = new ImageDto();
			img.setImageFilename(procedure.getGuideImgName());
			img.setImageStatus(ImageStatus.NoUpdate);
			Mixdto.setMixImage(img);
			Mixdto.setProcessText(procedure.getProcedure());
			mixprocessDtos.add(Mixdto);
		}
		dto.setMixprocessList(mixprocessDtos);
		
		ArrayList<String> notes = detail.getNote();
		dto.setNotes(notes);
		
		return dto;
	}
}

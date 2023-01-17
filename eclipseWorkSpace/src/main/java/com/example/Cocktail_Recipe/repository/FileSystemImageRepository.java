package com.example.Cocktail_Recipe.repository;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FileSystemImageRepository implements ImageRepository {

	@Value("${spring.servlet.multipart.location}")
	String filePath;

	@Value("${resource.drinkImgsDirName}")
	String drinkImgsPath;

	@Value("${resource.ProcedureImgsDirName}")
	String ProcedureImgsPath;

	// 현재 사용안하는중
	public void GetpathFileNames() {
		File dir = new File(filePath);
		String files[] = dir.list();

		for (int i = 0; i < files.length; i++) {
			System.out.println("file: " + files[i]);
		}
	}

	// 현재 사용안하는중
	public ArrayList<String> GetAllImagesName() {
		// TODO Auto-generated method stub
		File dir = new File(filePath);
		return (ArrayList<String>) List.of(dir.list());
	}

	// 칵테일 이미지 or 제조법 이미지를 해당 레시피에 대응하는 폴더에 맞게 저장.
	// bool 칵테일 이미지 or 제조법 이미지 폴더에 저장 할 지 선택
	@Override
	public void uploadImg(MultipartFile image, boolean SaveDrinkImg, String RecipeUUID)
			throws IllegalStateException, IOException {
		// TODO Auto-generated method stub
		String folderPath;
		// 이미지 를 저장 할 폴더 선택
		if (SaveDrinkImg) {
			folderPath = drinkImgsPath;
		} else {
			folderPath = ProcedureImgsPath;
		}

		if (!image.isEmpty()) {
			// 이미지 경로 생성
			File newFileName = new File(folderPath + "/" + RecipeUUID + "/" + image.getOriginalFilename());
			// 루트 폴더 경로 + 위에서 선택한 경로 + UUID_레시피이름 + 지금 생성한 UUID_이미지 파일이름
			image.transferTo(newFileName);
			// 실제로 이미지 저장
			log.info("Filesystem ====== getpath : " + newFileName.getPath());
		}
	}

	@Override
	public void Imagedelete(String UUID, String imgname, boolean SaveDrinkImg) {
		// TODO Auto-generated method stub
		String folderPath;
		// 이미지 를 저장 할 폴더 선택
		if (SaveDrinkImg) {
			folderPath = drinkImgsPath;
		} else {
			folderPath = ProcedureImgsPath;
		}

		Path delpath = Paths.get(folderPath + "/" + UUID + "/" + imgname);
		log.info("file system ====== delete path : " + delpath);

		try {
			// 파일 삭제
			Files.delete(delpath);
		} catch (NoSuchFileException e) {
			log.info("삭제하려는 파일/디렉토리가 없습니다");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void createRecipeDir(String NewUUID, boolean SaveDrinkImg) {
		// TODO Auto-generated method stub
		String folderPath;
		// 이미지 를 저장 할 폴더 선택
		if (SaveDrinkImg) {
			folderPath = drinkImgsPath;
		} else {
			folderPath = ProcedureImgsPath;
		}

		File newdirName = new File(filePath + "/" + folderPath + "/" + NewUUID);
		log.info(newdirName.toString());

		if (!newdirName.exists()) {
			if (newdirName.mkdir()) {
				log.info("폴더가 생성되었습니다.");
			} else {
				log.info("생성실패");
			}
		} else {
			log.info("이미 폴더가 생성되어 있습니다.");
		}

	}

	@Override
	public void DeleteAllRecipeDir(String RecipeUUID) {
		// TODO Auto-generated method stub
		File deleteCockDir = new File(filePath + "/" + drinkImgsPath + "/" + RecipeUUID);
		File deleteMixDir = new File(filePath + "/" + ProcedureImgsPath + "/" + RecipeUUID);

		deldir(deleteCockDir);
		deldir(deleteMixDir);
	}

	private void deldir(File dir) {
		if (dir.exists()) {
			for (File img : dir.listFiles()) {
				log.info("delete img ===========>" + img.getName());
				img.delete();
			}
			if (dir.listFiles().length == 0 && dir.isDirectory()) {
				dir.delete();
			}
		}
	}

	@Override
	public ArrayList<String> GetDrinkImgsPath(String DirPath) {
		// TODO Auto-generated method stub
		File dir = new File(filePath + "/" + drinkImgsPath + "/" + DirPath);
		log.info(filePath + "/" + drinkImgsPath + "/" + DirPath);
		String[] files = dir.list();

		ArrayList<String> list = new ArrayList<String>();
		if (files != null) {
			for (String file : files) {
				file = drinkImgsPath + "/" + DirPath + "/" + file;
				log.info("drinkimgname : " + file);
				list.add(file);
			}
		}
		return list;
	}

	@Override
	public String GetProcedureImgPath(String ImgName, String DirPath) {
		// TODO Auto-generated method stub
		String path = ProcedureImgsPath + "/" + DirPath + "/" + ImgName;
		String realpath = filePath + "/" + path;
		File dir = new File(realpath);

		log.info(realpath);

		if (dir.exists()) {
			return path;
		}

		return null;
	}

}

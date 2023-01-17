package com.example.Cocktail_Recipe.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.Cocktail_Recipe.domain.ImageStatus;
import com.example.Cocktail_Recipe.domain.Recipe_Material;
import com.example.Cocktail_Recipe.domain.Recipe_Procedure;
import com.example.Cocktail_Recipe.domain.Recipe_detail;
import com.example.Cocktail_Recipe.domain.Dto.ImageDto;
import com.example.Cocktail_Recipe.domain.Dto.MixprocessDto;
import com.example.Cocktail_Recipe.domain.Dto.RecipeDto;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class RecipeJsonService {

	public String createDetailJson(RecipeDto dto) {
		// 데이터 준비!
		ArrayList<String> notes = dto.getNotes();

		ArrayList<String> mnames = dto.getMaterialnames();
		ArrayList<String> vols = dto.getVolumes();

		ArrayList<MixprocessDto> Mixprocess = (ArrayList<MixprocessDto>) dto.getMixprocessList();

		Recipe_detail detail = new Recipe_detail();

		// 재료 데이터 삽입
		ArrayList<Recipe_Material> materials = new ArrayList<Recipe_Material>();
		if (!mnames.isEmpty()) {
			for (int i = 0; i < mnames.size(); i++) {
				Recipe_Material material = new Recipe_Material();
				material.setMaterialName(mnames.get(i));
				material.setVolume(Integer.parseInt(vols.get(i)));
				materials.add(material);
			}
		}

		detail.setMaterials(materials);

		// 특이사항 데이터 삽입
		ArrayList<String> noteArr = notes;
		detail.setNote(noteArr);

		// 믹스 과정 객채 할당 후 데이터 삽입
		ArrayList<Recipe_Procedure> procedures = new ArrayList<Recipe_Procedure>();

		// json 에서 저장헤야 할것 : 믹스 과정, 이미지 이름(경로 아님)
		if (!Mixprocess.isEmpty()) {
			for (MixprocessDto Mixp : Mixprocess) {
				Recipe_Procedure procedure = new Recipe_Procedure();
				procedure.setProcedure(Mixp.getProcessText());

				ImageStatus sta = Mixp.getMixImage().getImageStatus();

				log.info("status : " + sta.toString());

				if (sta == ImageStatus.New || sta == ImageStatus.Update) {
					log.info("new Mix img ============> " + Mixp.getMixImage().getFile().getOriginalFilename());
					procedure.setGuideImgName(Mixp.getMixImage().getFile().getOriginalFilename());

				}

				if (sta == ImageStatus.NoUpdate) {
					log.info("Old Mix img ============> " + Mixp.getMixImage().getImageFilename());
					procedure.setGuideImgName(Mixp.getMixImage().getImageFilename());
				}

				procedures.add(procedure);
			}
		}

		detail.setProcedures(procedures);

		// 실제 json 변환
		Gson gson = new Gson();
		String DetailJson = gson.toJson(detail);
		log.info(DetailJson);

		return DetailJson;
	}
}

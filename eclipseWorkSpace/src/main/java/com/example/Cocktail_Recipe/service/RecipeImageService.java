package com.example.Cocktail_Recipe.service;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Cocktail_Recipe.domain.ImageStatus;
import com.example.Cocktail_Recipe.domain.Dto.ImageDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class RecipeImageService {

	@Autowired
	private ImageService imageService;

	public void UpdateImg(String recipeuuid, ArrayList<ImageDto> newimg, ArrayList<ImageDto> oldimg, boolean isCockimg)
			throws IOException {
		// 먼저 상태가 new 인 이미지 부터 파일 시스템 에 저장 해야함.
		for (ImageDto img : newimg) {
			// 새로 들어온 or 업테이트 된 - multifile 이 존재하는 imgdto 들은 파일 시스템에
			// 새로 저장한다.
			if (img.getImageStatus() == ImageStatus.New) {
				log.info("new img =========> " + img.getFile().getOriginalFilename());
				imageService.NewImageUpload(img.getFile(), recipeuuid, isCockimg);
				log.info("=============== upload complete ==============");
			}

			// update 시 리스트에 이미지 파일 존재 여부와 상관없이
			// multi 내용 업로드 후 filename 이름이 같은 파일을 삭제 해야함.
			// Mix img 에서 원래 아무런 이미지 가 없는데 수정 할 때 이미지가 추가되는 경우
			// 원래 이미지 가 없으니 img.getImageFilename() null 을 반환
			// 이러면 삭제가 안됨 <= 해결.
			
			if (img.getImageStatus() == ImageStatus.Update) {
				log.info("=============== update ==============");
				log.info("new img =========> " + img.getFile().getOriginalFilename());
				log.info("delete img ==========> " + img.getImageFilename());
				if(!img.getImageFilename().isBlank() || !img.getImageFilename().isEmpty()) {
					imageService.Imagedelete(recipeuuid, img.getImageFilename(), isCockimg);
				}
				imageService.NewImageUpload(img.getFile(), recipeuuid, isCockimg);
				log.info("=============== update complete ==============");
			}
		}

		boolean imgdel = true;
		// 원래 있던 이미지 가 새로 들어온 이미지 목록에없을 경우 삭제
		for (ImageDto oimg : oldimg) {
			imgdel = true;
			for (ImageDto nimg : newimg) {
				// imagestatus 가 update 일 경우 원래 dto 에 저장되어 있던 이미지를
				// 삭제하는 동작이 필요함
				// update 시 multipartfile 에 이미지 정보가 저장되니
				// 이건 업로드 하고 원래 imgname 이름의 파일을 삭제하는 조치가 필요.
				// new 이미지는 원래 폴더에 없던 이미지니 제외
				// update
				if (nimg.getImageStatus() != ImageStatus.New) {
					if (nimg.getImageFilename().equals(oimg.getImageFilename())) {
						imgdel = false;
						break;
					}
				}
			}
			if (imgdel) {
				if (oimg != null) {
					if (!oimg.getImageFilename().isEmpty() && !oimg.getImageFilename().isBlank()) {
						// update 체크 할 때 이미 삭제한 이미지를 다시 삭제하는 오류 있음
						log.info("delete img ==========> " + oimg.getImageFilename());
						imageService.Imagedelete(recipeuuid, oimg.getImageFilename(), isCockimg);
						log.info("============ delete complete ============");
					}
				}
			}
		}

	}

}

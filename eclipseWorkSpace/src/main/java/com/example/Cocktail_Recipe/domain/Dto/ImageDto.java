package com.example.Cocktail_Recipe.domain.Dto;

import org.springframework.web.multipart.MultipartFile;

import com.example.Cocktail_Recipe.domain.ImageStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ImageDto {

	//create 의 경우 MultipartFile
	//update 의 경우 파일 시스템 상 저장된 이미지 파일 이름
	//이미지가 새로 저장되는 놈인지, 수정된 놈인지, 원래 있었지만 수정되지 않음 놈인지 알려줄 enum
	//삭제 되면 dto 의 list 에서 없어지니...
	
	private MultipartFile file;
	private String imageFilename;
	private ImageStatus imageStatus;
	
}

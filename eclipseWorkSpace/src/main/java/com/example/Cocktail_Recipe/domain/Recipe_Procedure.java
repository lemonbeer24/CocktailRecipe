package com.example.Cocktail_Recipe.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Recipe_Procedure {

	//믹스과정 설명
	private String Procedure;
	//이해에 도움을 줄 이미지
	private String guideImgName;
	//이미지의 실제경로, json 에서는 저장되지 않고 RecipeService 에서 Recipe 를 불러 올 때 메소드에 의해 초기화 된다
	//이유는 저장시 json 에 저장한 경로가 불러 올 때 시스템에서의 경로와 다를 수 있기 때문이다.
	private String guideImgPath;
	
}

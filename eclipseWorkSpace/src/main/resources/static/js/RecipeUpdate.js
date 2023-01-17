/**
 * 
 */

const Recipedata = dto;

function init() {
	if (Recipedata.cocktailName != undefined || Recipedata.cocktailName != null) {
		console.log("update test : " + Recipedata.cocktailName);

		//재료 업데이트 input 생성
		var matername = Recipedata.materialnames;
		var matervol = Recipedata.volumes;
		for (var i in matername) {
			createMater(matername[i], matervol[i]);
		}
		
		//칵테일 이미지 업데이트 input 생성
		var cockimgs = Recipedata.cocktailImages;
		for(var i in cockimgs) {
			UpdateCockImginput(cockimgs[i].imageFilename, cockimgs[i].imageStatus)
		}
		
		//특이사항 업데이트 input 생성
		var notes = Recipedata.notes;
		for(var i in notes) {
			createNote(notes[i]);
		}
		
		//믹스 과정 엡데이트 input 생성
		var Mixdtos = Recipedata.mixprocessList;
		console.log(Mixdtos.size);
		for(var i in Mixdtos) {
			console.log(Mixdtos[i].mixImage.imageFilename);
			createMixProcess(Mixdtos[i].mixImage.imageFilename,
				Mixdtos[i].mixImage.imageStatus, Mixdtos[i].processText)
		}
		
	}
}

init();
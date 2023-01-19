/**
 * 
 */
 
 const AddmaterBtn = document.getElementById("Addmater");
 const AddMixBtn = document.getElementById("AddMix");
 const AddnoteBtn = document.getElementById("Addnote");;
 
 const notesdiv = document.getElementById("notes");
 const materialdiv = document.getElementById("materials");
 const MixProcessdiv = document.getElementById("Mixprocess");
 
 const AddcockImgBtn = document.getElementById("addcockImgBtn");
 const cockImgsDiv = document.getElementById("cockImgs");
 
 const realsubmitbtn = document.getElementById("realsubmit");
 
 var nextMaterId = 0;
 var AddmaterDocsDic = {};
 
 var nextMixId = 0;
 var AddMixDic = {};
 
 var nextNoteId = 0;
 var AddNoteDiv = {};
 
 const CheckFileTypes = 
 [
	"image/gif", "image/jpg", "image/png", "image/jpeg",
 ];
 
 function Addmater()
 {
	createMater()
 }
 
 function createMater(materName,vol,unit)
 {
	var materDiv = document.createElement("div");
	materDiv.setAttribute("class", "materinput");
	
	var namelabel = document.createElement("label");
	namelabel.innerText = "재료 이름 : ";
	materDiv.appendChild(namelabel);
	
	var materialname = document.createElement("input");
	materialname.setAttribute("type","text");
	materialname.setAttribute("class","materialname");
	materialname.setAttribute("name","materialnames[]");
	materialname.setAttribute("required","true");
	
	if(materName != undefined) {
		materialname.setAttribute("value", materName);
	}
	
	materDiv.appendChild(materialname);
	
	namelabel = document.createElement("label");
	namelabel.innerText = "용량 : ";
	materDiv.appendChild(namelabel);
	
	var volume = document.createElement("input");
	volume.setAttribute("type","number");
	volume.setAttribute("class","volume");
	volume.setAttribute("min","0");
	volume.setAttribute("name","volumes[]");
	volume.setAttribute("required","true");
	
	if(vol != undefined) {
		volume.setAttribute("value", vol);
	}
	
	materDiv.appendChild(volume);
	
	namelabel = document.createElement("label");
	namelabel.innerText = "단위 : ";
	materDiv.appendChild(namelabel);
	
	var unitinput = document.createElement("input");
	unitinput.setAttribute("type","text");
	unitinput.setAttribute("class","unit");
	unitinput.setAttribute("name","units[]");
	unitinput.setAttribute('required','true');
	
	if(unit) {
		unitinput.setAttribute("value", unit);
	}
	
	materDiv.appendChild(unitinput);
	
	AddDelBtn(materDiv,nextMaterId,"mater");
	
	materDiv.appendChild(document.createElement("br"));
	materialdiv.appendChild(materDiv);
	
	AddmaterDocsDic[nextMaterId] = materDiv;
	nextMaterId++;
 }
 
 function AddMixProcess()
 {
	createMixProcess();
 }
 
 function createMixProcess(imgname, imgstatus, mixstr)
 {
	var MixDiv = document.createElement("div");
	MixDiv.setAttribute("class", "Mixinput");
	
	var namelabel = document.createElement("label");
	namelabel.innerText = "믹스 과정 : ";
	MixDiv.appendChild(namelabel);
	MixDiv.appendChild(document.createElement("br"));
	
	var MixTextArea = document.createElement("textarea");
	MixTextArea.setAttribute("rows","10");
	MixTextArea.setAttribute("cols","50");
	MixTextArea.setAttribute("required","true");
	
	if(mixstr != undefined){
		MixTextArea.textContent = mixstr;
	}
	
	MixDiv.appendChild(MixTextArea);
	MixDiv.appendChild(document.createElement("br"));
	
	var imagelabel = document.createElement("label");
	imagelabel.innerText = "가이드 이미지 : "
	MixDiv.appendChild(imagelabel);
	if(imgstatus != undefined && imgname != undefined) {
		AddImgInput(MixDiv,'Miximginput',imgstatus,imgname,false);
	} else {
		AddImgInput(MixDiv,'Miximginput','New',null,false);
	}
	
	AddDelBtn(MixDiv,nextMixId,"Mix");
	
	MixDiv.appendChild(document.createElement("br"));
	MixProcessdiv.appendChild(MixDiv);
	
	AddMixDic[nextMixId] = MixDiv;
	nextMixId++;
 }
 
 function Addnote()
 {
	createNote()
 }
 
 function createNote(note)
 {
	var noteDiv = document.createElement("div");
	
	var noteTextBox = document.createElement("input");
	noteTextBox.setAttribute("type","text");
	noteTextBox.setAttribute("class","note");
	noteTextBox.setAttribute("name","notes[]");
	
	if(note != undefined){
		noteTextBox.setAttribute("value",note);
	}
	
	noteDiv.appendChild(noteTextBox);
	
	AddDelBtn(noteDiv,nextNoteId,"note");
	noteDiv.appendChild(document.createElement("br"));
	
	notesdiv.appendChild(noteDiv);
	
	AddNoteDiv[nextNoteId] = noteDiv;
	nextNoteId++;
 }
 
 function AddImgInput(appendTarget, classstr, status, imgname, isMixinput)
 {
	var rootDiv = document.createElement("div");
	rootDiv.setAttribute("class", classstr);

	var uploadNameText = document.createElement("a");
	uploadNameText.setAttribute("class", "upload-name");
	if(imgname){
		uploadNameText.textContent = imgname;
	} else {
		uploadNameText.textContent = "첨부파일 이름....";
	}
	
	rootDiv.appendChild(uploadNameText);
		
	var label = document.createElement("label");
	label.textContent = "파일찾기...";
		
	var input = document.createElement("input");
	input.setAttribute("type","file");
	input.setAttribute("accept", ".gif, .jpg, .png");
	input.addEventListener("change",  adduploadImage);
	label.appendChild(input);
	rootDiv.appendChild(label);
	
	var imgstatus = document.createElement("input");
	imgstatus.setAttribute("type","hidden");
	imgstatus.setAttribute("value", status);
	rootDiv.appendChild(imgstatus);
	
	var imghidden = document.createElement("input");
	imghidden.setAttribute("type","hidden");
	if(imgname){
		imghidden.setAttribute("value", imgname);
	}
	rootDiv.appendChild(imghidden);
	
	if(isMixinput){	
		var DelBtn = document.createElement("button");
		DelBtn.setAttribute("type", "button");
		DelBtn.textContent = "삭제...";
		DelBtn.addEventListener("click", delimageinput);
		rootDiv.appendChild(DelBtn);
	}
	
	appendTarget.appendChild(rootDiv);
 }
 
 function NewAddCockImginput()
 {
	AddImgInput(cockImgsDiv,'cockimginput','New',null,true);
 }
 
 function UpdateCockImginput(imgname,status)
 {
	AddImgInput(cockImgsDiv,'cockimginput',status,imgname,true);
 }
 
 function adduploadImage(event)
 {
	const input = event.target;
	var filename = input.value.substr(12);
	input.parentNode.parentNode.childNodes[0].textContent = filename;
	var status = input.parentNode.parentNode.childNodes[2].getAttribute("value");
	if(status != "New"){
		input.parentNode.parentNode.childNodes[2].setAttribute("value","Update");
 	}
 }
 
 function AddDelBtn(Div,value,classval)
 {
	var delBtn = document.createElement("button");
	delBtn.setAttribute("type","button");
	delBtn.setAttribute("value",value);
	delBtn.setAttribute("class",classval);
	delBtn.addEventListener("click",del);
	delBtn.innerText = "삭제";
	Div.appendChild(delBtn);
 }
 
 function fileTypeCheck(event)
 {
	const input = event.target;
	const selectedFiles = input.files;
	
	for(const file of selectedFiles)
	{
		console.log(file.type);
		if(!CheckFileTypes.includes(file.type))
		{
			alert("업로드 파일 중 이미지가 아닌 파일이 있습니다\n 이미지 파일을 넣어 주세요");
			input.value = null;
			return;
		}
	}
 }
 
 function delimageinput(event)
 {
	const btn = event.target;
	console.log(btn.parentNode);
	btn.parentNode.remove();
 }
 
 function del(event)
 {
	const button = event.target;
	var controlDiv;
	var controlDic;
	console.log(button.value);
	console.log(button.parentNode);
	console.log(button.className);
	switch(button.className)
	{
		case "mater":
			controlDiv = materialdiv;
			controlDic = AddmaterDocsDic;
			break;
		
		case "Mix":
			controlDiv = MixProcessdiv;
			controlDic = AddMixDic;
			break;
			
	    case "note":
	    	controlDiv = notesdiv;
	    	controlDic = AddNoteDiv;
			break;
		default:
	}
	
	controlDiv.removeChild(controlDic[button.value]);
	delete controlDic[button.value];
 }
 
 function InputTagNameing() 
 {
	//칵테일 이미지 input name update
	var selectedItem = document.getElementsByClassName("cockimginput");
	for(var i = 0; i < selectedItem.length; i++)
	{
		var nameStr = "cocktailImages[" + i + "].file";
		selectedItem[i].childNodes[1].childNodes[1]
			.setAttribute("name", nameStr);
			
		var nameStr = "cocktailImages[" + i + "].imageStatus";
		selectedItem[i].childNodes[2]
			.setAttribute("name", nameStr);
			
		var nameStr = "cocktailImages[" + i + "].imageFilename";
		selectedItem[i].childNodes[3]
			.setAttribute("name", nameStr);
	}
	
	selectedItem = document.getElementsByClassName("Mixinput");
	for(var i = 0; i < selectedItem.length; i++)
	{
		console.log(selectedItem[i].childNodes[2]);
		console.log(selectedItem[i].childNodes[5].childNodes[1].childNodes[1]);
	
		var nameStr = "MixprocessList[" + i + "].processText";
		selectedItem[i].childNodes[2]
			.setAttribute("name", nameStr);
		
		var nameStr = "MixprocessList[" + i + "].mixImage.file";
		selectedItem[i].childNodes[5].childNodes[1].childNodes[1]
			.setAttribute("name", nameStr);
			
		var nameStr = "MixprocessList[" + i + "].mixImage.imageStatus";
		selectedItem[i].childNodes[5].childNodes[2]
			.setAttribute("name", nameStr);
			
		var nameStr = "MixprocessList[" + i + "].mixImage.imageFilename";
		selectedItem[i].childNodes[5].childNodes[3]
			.setAttribute("name", nameStr);
	}
 }
 
 function init()
 {
	AddmaterBtn.addEventListener("click",Addmater);
	AddMixBtn.addEventListener("click",AddMixProcess);
	AddnoteBtn.addEventListener("click",Addnote);
	AddcockImgBtn.addEventListener("click",NewAddCockImginput);
 }
 
 window.onload = function() 
 {
	document.getElementById('submitbtn').onclick = function(){
		
		if(document.getElementsByClassName("materinput").length <= 0){
			alert("재료는 하나이상 입력하셔야 합니다.");
			return;
		}
		
		//칵테일 이미지 input name update
		var selectedItem = document.getElementsByClassName("cockimginput");
		
		if(document.getElementsByClassName("cockimginput").length <= 0){
			alert("칵테일 이미지는 하나이상 입력하셔야 합니다.");
			return;
		}
		
		for(var i = 0; i < selectedItem.length; i++)
		{
			var nameStr = "cocktailImages[" + i + "].file";
			selectedItem[i].childNodes[1].childNodes[1]
				.setAttribute("name", nameStr);
			
			var nameStr = "cocktailImages[" + i + "].imageStatus";
			selectedItem[i].childNodes[2]
				.setAttribute("name", nameStr);
			
			var nameStr = "cocktailImages[" + i + "].imageFilename";
			selectedItem[i].childNodes[3]
				.setAttribute("name", nameStr);
		}
	
		selectedItem = document.getElementsByClassName("Mixinput");
		
		if(selectedItem.length <= 0){
			alert("믹스 과정은 하나 이상 입력하셔야 합니다");
			return;
		}
		
		for(var i = 0; i < selectedItem.length; i++)
		{
			console.log(selectedItem[i].childNodes[2]);
			console.log(selectedItem[i].childNodes[5].childNodes[1].childNodes[1]);
	
			var nameStr = "MixprocessList[" + i + "].processText";
			selectedItem[i].childNodes[2]
				.setAttribute("name", nameStr);
		
			var nameStr = "MixprocessList[" + i + "].mixImage.file";
			selectedItem[i].childNodes[5].childNodes[1].childNodes[1]
				.setAttribute("name", nameStr);
			
			var nameStr = "MixprocessList[" + i + "].mixImage.imageStatus";
			selectedItem[i].childNodes[5].childNodes[2]
				.setAttribute("name", nameStr);
			
			var nameStr = "MixprocessList[" + i + "].mixImage.imageFilename";
			selectedItem[i].childNodes[5].childNodes[3]
				.setAttribute("name", nameStr);
		}
		
		realsubmitbtn.click();
		//document.getElementById('frm').submit();
	}
 }
 
 init();
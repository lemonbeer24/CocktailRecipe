/**
 * 
 */
 
let curPos = 0;
let postion = 0;
var imgcount;
const IMAGE_WIDTH = 400;
const prevBtn = document.getElementById("prev");
const nextBtn = document.getElementById("next");
const images = document.querySelector(".images");

function prev(){
  if(curPos > 0){
    nextBtn.removeAttribute("disabled");
    postion += IMAGE_WIDTH;
    images.style.transform = `translateX(${postion}px)`;
    curPos = curPos - 1;
  }
  if(curPos == 0){
    prevBtn.setAttribute('disabled', 'true');
  }
}

function next(){
  if(curPos < imgcount){
    prevBtn.removeAttribute("disabled");
    postion -= IMAGE_WIDTH;
    images.style.transform = `translateX(${postion}px)`;
    curPos = curPos + 1;
  }
  if(curPos == imgcount){
    nextBtn.setAttribute('disabled', 'true');
  }
}
 
function init(){
  imgcount = document.getElementsByClassName("image").length - 1;
  prevBtn.setAttribute('disabled', 'true');
  prevBtn.addEventListener("click", prev);
  nextBtn.addEventListener("click", next);
}

init();
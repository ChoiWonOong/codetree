const fs = require("fs");
let input = fs.readFileSync(0).toString().trim();
let answer = "";
for(i=0; i<input.length; i++){
    if(i==1 || i==input.length-2){
        answer+='a';
    }else{
        answer+=input[i];
    }
}
console.log(answer);
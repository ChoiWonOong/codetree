const fs = require("fs");
let input = Number(fs.readFileSync(0).toString().trim());
let answer = "";
for(i=input; i<=100; i++){
    if(i/10>=9){
        answer+="A" + " ";
    }else if(i/10>=8){
        answer += "B" + " ";
    }else if(i/10>=7){
        answer += "C" + " ";
    }else if(i/10 >= 6){
        answer +="D" + " ";
    }else{
        answer += "F" + " ";
    }
}
console.log(answer);
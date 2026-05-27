const fs = require("fs");
let input = fs.readFileSync(0).toString().trim();
let answer = "";
for(i=0; i<input.length; i++){
    if(input[i] == ' ' || input[i] == '\n'){
        
    }else{
        answer += input[i];
    }
}
console.log(answer);
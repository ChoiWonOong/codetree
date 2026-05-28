const fs = require("fs");
let input = fs.readFileSync(0).toString().trim();
let answer = "";
for(i=input.length-1; i>=0; i--){
    if(i%2==1){
        answer+=input[i];
    }
}
console.log(answer);
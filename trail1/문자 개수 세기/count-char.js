const fs = require("fs");
let input = fs.readFileSync(0).toString().trim().split('\n');
let word = input[0];
let cnt = 0;
for(i=0; i<word.length; i++){
    if(word[i] == input[1]){
        cnt++
    }
}
console.log(cnt);
const fs = require("fs");
let input = fs.readFileSync(0).toString().trim();
let alph;
let cnt = 0;
let str = "";
for(let i=0; i<input.length; i++){
    if(alph == null){
        alph = input.charAt(i);
        str=alph;
    }
    if(alph != input.charAt(i)){
        alph = input.charAt(i);
        str+=cnt;
        str+=alph;
        cnt = 0;
    }
    cnt++;
}
str+=cnt;
console.log(str.length);
console.log(str);
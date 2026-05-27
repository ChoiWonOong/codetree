const fs = require("fs");
let input = fs.readFileSync(0).toString().trim().split("\n");
let cnt = 0;
for(i=0; i<input.length; i++){
    cnt += input[i].length;
}
console.log(cnt);
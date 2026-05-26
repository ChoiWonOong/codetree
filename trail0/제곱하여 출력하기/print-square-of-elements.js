const fs = require("fs");
let input = fs.readFileSync(0).toString().trim().split('\n');
let n = Number(input[0]);
let arr = input[1].split(' ');
let answer = "";
for(i=0; i<n; i++){
    answer += Number(arr[i])*Number(arr[i]) + " ";
}
console.log(answer);
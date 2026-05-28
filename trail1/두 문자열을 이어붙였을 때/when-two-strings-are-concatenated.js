const fs = require("fs");
let input = fs.readFileSync(0).toString().trim().split("\n");
let a = input[0];
let b = input[1];
if(a+b == b+a){
    console.log(true);
}else{
    console.log(false);
}
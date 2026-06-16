const fs = require("fs");
let input = fs.readFileSync(0).toString().trim().split(" ");
let length1 = input[0].length;
let length2 = input[1].length;
if(length1==length2){
    console.log("same");
}else{
    console.log((length1>length2) ? input[0] + " " + length1 : input[1] + " " + length2);
}
const fs = require("fs");
let input = fs.readFileSync(0).toString().trim().split(' ');
let aLength = input[0].length;
let bLength = input[1].length
if(aLength > bLength){
    console.log(input[0] + " " + aLength);
}else if(aLength < bLength){
    console.log(input[1] + " " + bLength);
}else{
    console.log("same");
}
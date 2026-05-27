const fs = require("fs");
let input = fs.readFileSync(0).toString().trim().split('\n');

for(i=0; i<3; i++){
    let rowA = input[i].split(" ");
    let rowB = input[i+4].split(" ");
    let print = "";
    for(j = 0; j<rowA.length; j++){
        print = print + Number(rowA[j]) * Number(rowB[j]) + " ";
    }
    console.log(print);
}
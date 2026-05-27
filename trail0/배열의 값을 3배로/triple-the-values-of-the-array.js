const fs = require("fs");
let input = fs.readFileSync(0).toString().trim().split('\n');
let arr = [];
for(i=0; i<input.length; i++){
    let row = input[i].split(" ");
    let print = "";
    for(j=0; j<row.length;j++){
        print = print + Number(row[j]*3) + " ";
    }
    console.log(print);
}

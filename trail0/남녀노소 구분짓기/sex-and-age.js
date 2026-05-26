const fs = require("fs");
let input = fs.readFileSync(0).toString().trim().split('\n');
let gender = Number(input[0]);
let age = Number(input[1]);

if(gender == 0){
    if(age>18){
        console.log("MAN");
    }else{
        console.log("BOY");
    }
}else{
    if(age>18){
        console.log("WOMAN");
    }else{
        console.log("GIRL");
    }
}
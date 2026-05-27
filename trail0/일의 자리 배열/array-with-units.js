const fs = require("fs");
let input = fs.readFileSync(0).toString().trim().split(' ');
let answer = [];
answer.push(Number(input[0]));
answer.push(Number(input[1]));
for (i = 2; i < 10; i++) {
    let temp = Number(answer[i - 1]) + Number(answer[i - 2]);
    if (temp < 10) {
        answer.push(temp);
    } else {
        answer.push(temp - 10);
    }
}
let print = "";
for(i=0; i<10; i++){
    print= print + answer[i] + " ";
}
console.log(print);
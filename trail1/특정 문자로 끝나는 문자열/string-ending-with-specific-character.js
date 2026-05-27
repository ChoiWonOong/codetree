const fs = require("fs");

let input = fs.readFileSync(0).toString().trim().split("\n");

let alphabet = input[input.length-1];
let answer = [];

for (let i = 0; i < input.length - 1; i++) {
    let word = input[i];

    if (word[word.length-1]==alphabet) {
        answer.push(word);
    }
}

if (answer.length == 0) {
    console.log("None");
} else {
    for (let i = 0; i < answer.length; i++) {
        console.log(answer[i]);
    }
}
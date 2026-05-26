const fs = require("fs");
let input = fs.readFileSync(0).toString().trim().split(' ');
let a = Number(input[0]);
let b = Number(input[1]);
let c = Number(input[2]);

let mid;

if (a >= b && a <= c) mid = a;  // b <= a <= c
else if (a <= b && a >= c) mid = a;  // c <= a <= b
else if (b >= a && b <= c) mid = b;  // a <= b <= c
else if (b <= a && b >= c) mid = b;  // c <= b <= a
else mid = c;

console.log(mid);
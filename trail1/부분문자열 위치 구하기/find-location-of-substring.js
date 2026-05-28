const fs = require("fs");
let input = fs.readFileSync(0).toString().trim().split('\n');
let a = input[0];
let b = input[1];
let flag = -1;
for(i=0; i<a.length-b.length+1; i++){
    let cnt = 0;
    for(j=0; j<b.length; j++){
        if(a[i+j]==b[j]){
            cnt++;
        }
    }
    if(cnt == b.length){
        flag = i;
        break;
    }
}
console.log(flag);
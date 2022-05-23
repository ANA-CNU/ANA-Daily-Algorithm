var fs = require("fs");
//var filePath = "/dev/stdin";
var filePath = __dirname + "/input.txt";

var input = fs.readFileSync(filePath).toString();
var change = 1000 - parseInt(input);
let money = [500, 100, 50, 10, 5, 1];

var result = 0;

for (var i = 0; i < 6; i++) {
  if (change <= 0) {
    break;
  }
  let num = parseInt(change / money[i]);
  result = result + num;
  change = change - num * money[i];
}

console.log(result);

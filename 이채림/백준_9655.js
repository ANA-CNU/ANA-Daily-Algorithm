var fs = require("fs");
//var filePath = "/dev/stdin";
var filePath = __dirname + "/input.txt";

var input = fs.readFileSync(filePath).toString();

var N = parseInt(input);

if (N % 2 == 0) {
  // 짝수 -> 창영 승
  console.log("CY");
} else {
  // 홀수 -> 상근 승
  console.log("SK");
}

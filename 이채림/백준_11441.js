var fs = require("fs");
var filePath = __dirname + "/input.txt";
//var filePath = "/dev/stdin";

var input = fs.readFileSync(filePath).toString().trim().split("\n");
var N = Number(input[0]);
var An = input[1].split(" ").map(Number);
var M = Number(input[2]);

var cumulativeSum = [];
cumulativeSum.push(0);
cumulativeSum.push(An[0]);

for (var i = 1; i < N; i++) {
  cumulativeSum.push(cumulativeSum[i] + An[i]);
}

var result = [];

for (var k = 3; k < M + 3; k++) {
  var ij = input[k].split(" ").map(Number);
  var i = ij[0] - 1;
  var j = ij[1];
  result.push(cumulativeSum[j] - cumulativeSum[i]);
}
// console.log는 시간이 오래걸림.
console.log(result.join("\n"));

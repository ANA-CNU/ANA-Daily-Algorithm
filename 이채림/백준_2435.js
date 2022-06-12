var fs = require("fs");
//var filePath = "/dev/stdin";
var filePath = __dirname + "/input.txt";

var input = fs.readFileSync(filePath).toString().split("\n");

var firstLine = input[0].split(" ");
var N = parseInt(firstLine[0]);
var K = parseInt(firstLine[1]);

var secondLine = input[1].split(" ").map(Number);

var arr = new Array(N - K + 1);

for (var i = 0; i < arr.length; i++) {
  arr[i] = 0;
}

var max = -10000;

for (var i = 0; i < arr.length; i++) {
  for (var j = i; j < i + K; j++) {
    arr[i] += secondLine[j];
  }
  if (max < arr[i]) {
    max = arr[i];
  }
}

console.log(max);

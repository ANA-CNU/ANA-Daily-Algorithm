const { reverse } = require("dns");
var fs = require("fs");
//var filePath = "/dev/stdin";
var filePath = __dirname + "/input.txt";

var input = fs.readFileSync(filePath).toString().split("\n");
var N = parseInt(input[0]);
var days = input[1].split(" ");

var max = parseInt(days[0]);

days = days.map(Number); // string -> number
// 내림차순 정렬
days.sort(function (a, b) {
  if (a > b) return -1;
  if (a == b) return 0;
  if (a < b) return 1;
});

for (var i = 0; i < days.length; i++) {
  days[i] = days[i] + i + 1;
  if (days[i] > max) {
    max = days[i];
  }
}

console.log(max + 1);

var fs = require("fs");
//var filePath = "/dev/stdin";
var filePath = __dirname + "/input.txt";

var input = fs.readFileSync(filePath).toString();

var T = parseInt(input);

var A = 0; // 5분 (300초)
var B = 0; // 1분 (60초)
var C = 0; // 10초

// A 개수 세기
A = A + parseInt(T / 300);
T = T - parseInt(T / 300) * 300;

// B 개수 세기
B = B + parseInt(T / 60);
T = T - parseInt(T / 60) * 60;

// C 개수 세기
C = C + parseInt(T / 10);
T = T - parseInt(T / 10) * 10;

if (T == 0) {
  console.log(A + " " + B + " " + C);
} else {
  console.log(-1);
}

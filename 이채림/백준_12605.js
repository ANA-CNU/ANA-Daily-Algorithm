var fs = require("fs");
//var filePath = "/dev/stdin";
var filePath = __dirname + "/input.txt";

var input = fs.readFileSync(filePath).toString().split("\n");

var N = parseInt(input[0]);

for (var i = 1; i <= N; i++) {
  var stack = [];
  var result = `Case #${i}: `;
  var str = input[i].split(" ");
  for (var j = 0; j < str.length; j++) {
    stack.push(str[j]);
  }
  for (var j = 0; j < str.length; j++) {
    var pop = stack.pop();
    result = result + pop.toString() + " ";
  }
  console.log(result);
}

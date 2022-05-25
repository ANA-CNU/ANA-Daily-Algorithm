var fs = require("fs");
//var filePath = "/dev/stdin";
var filePath = __dirname + "/input.txt";

var input = fs.readFileSync(filePath).toString();

var find = ["U", "C", "P", "C"];

var index = 0;

for (var i = 0; i < input.length; i++) {
  if (index >= 4) {
    break;
  }

  if (input[i] == find[index]) {
    index = index + 1;
  }
}

if (index === 4) {
  console.log("I love UCPC");
} else {
  console.log("I hate UCPC");
}

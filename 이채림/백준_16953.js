var fs = require("fs");
//var filePath = "/dev/stdin";
var filePath = __dirname + "/input.txt";

var input = fs.readFileSync(filePath).toString().split(" ");

var A = parseInt(input[0]);
var B = parseInt(input[1]);

var cnt = 1;
var check = true;

while (B > A) {
  if (B % 2 == 0) {
    B = B / 2;
    cnt += 1;
  } else if (B.toString().charAt(B.toString().length - 1) === "1") {
    const temp = B.toString().substring(0, B.toString().length - 1);
    B = parseInt(temp);
    cnt += 1;
  } else {
    check = false;
    break;
  }
}

if (B != A) {
  check = false;
}

if (check == false) {
  console.log(-1);
} else {
  console.log(cnt);
}

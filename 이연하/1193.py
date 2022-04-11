x = int(input())
line = 1

while x > line:
    x = x - line
    line = line+1

if line%2 == 0:
    a = x
    b = line-x+1
else:
    a = line-x+1
    b = x
print(a, '/', b, sep='')
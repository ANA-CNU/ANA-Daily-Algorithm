a = int(input())
b = 1

for i in range(1, a+1):
    b *= i

ret = 0

while b % 10 == 0:
    ret += 1
    b = b // 10
    
print(ret)
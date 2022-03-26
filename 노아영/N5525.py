import sys
n = int(sys.stdin.readline())
m = int(sys.stdin.readline())
s = sys.stdin.readline().rstrip().strip("O")

i, cnt, tmp = 0, 0, n
while True:
    if i >= len(s)-2:
        break
    if s[i] == "I" and s[i+1] == "O" and s[i+2] == "I":
        tmp -= 1
        if tmp == 0:
            cnt += 1
            tmp += 1
        i += 2
    else:
        tmp = n  
        i += 1
    
print(cnt) 
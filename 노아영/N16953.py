import sys
a, b = map(int, sys.stdin.readline().split())
cnt = 0
while b > a:
    if str(b)[-1] == "1":
        b = int(str(b)[:-1])
    elif b%2 == 1:
        break
    else:
        b = int(b/2)
    cnt += 1
if b == a:
    print(cnt+1)
else:
    print(-1)
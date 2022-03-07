import sys

a, b = map(str, sys.stdin.readline().split())
ans = 0
for i in range(len(b)-len(a)+1):
    tmpB, tmp = b[i:], 0
    for j in range(len(a)):
        if a[j] != tmpB[j]:
            tmp += 1
    if i == 0:
        ans = tmp
    ans = min(ans, tmp)
print(ans)
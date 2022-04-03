import sys
n, s = map(int, sys.stdin.readline().split())
lst = list(map(int, sys.stdin.readline().split()))
cnt = 0
for i in range(n):
    for j in range(i+1, n+1):
        tmp = lst[i:j]
        print(tmp)
        if sum(tmp) == s:
            cnt += 1
print(cnt)
import sys

n, m = map(int, sys.stdin.readline().strip().split())

if n == 0:
    print(0)
else:
    arr = list(map(int, sys.stdin.readline().strip().split()))
    cnt = 0
    ans = 1

    for i in arr:
        if cnt + i > m:
            ans += 1
            cnt = 0
        cnt += i

    print(ans)

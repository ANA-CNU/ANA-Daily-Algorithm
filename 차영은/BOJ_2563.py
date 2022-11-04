import sys

arr = [[0] * 101 for _ in range(101)]
T = int(sys.stdin.readline())
ans = 0

for _ in range(T):
    s, e = map(int, sys.stdin.readline().split())

    for i in range(s, s + 10):
        for j in range(e, e + 10):
            arr[i][j] = 1

for i in range(101):
    for j in range(101):
        if arr[i][j] == 1:
            ans += 1

print(ans)

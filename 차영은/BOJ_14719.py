import sys

h, w = map(int, sys.stdin.readline().split())
arr = [
    [0] * w
    for _ in range(h)
]

block = list(map(int, sys.stdin.readline().split()))
cnt = 0
ans = 0

for i in range(len(block)):
    for j in range(1, block[i] + 1):
        arr[h - j][i] = 1

for i in range(h):
    latest = 0
    tmp = 0
    for j in range(w):
        if latest >= 1:
            if arr[i][j] == 0:
                tmp += 1
                latest = 2
            elif arr[i][j] == 1:
                ans += tmp
                tmp = 0
                latest = 1
        else:
            if arr[i][j] == 1:
                latest = 1

print(ans)

import sys

N = int(sys.stdin.readline())
arr = []

for _ in range(N):
    p = tuple(map(int, sys.stdin.readline().strip().split()))
    arr.append(p)

for i in arr:
    cnt = 1
    for j in arr:
        if i[0] < j[0] and i[1] < j[1]:
            cnt += 1

    print(cnt, end=' ')

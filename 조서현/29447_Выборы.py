import sys

n = int(input())
arr = list(map(int, sys.stdin.readline().split()))
m = int(input())
queries = [list(map(int, sys.stdin.readline().split())) for _ in range(m)]

# 좌표 압축
comp = dict()
idx = 1
for e in sorted(arr):
    if e not in comp:
        comp[e] = idx
        idx += 1
for i in range(n):
    arr[i] = comp[arr[i]]

sqrt_n = int(n ** 0.5)
num = [0] * 100003
cnt = [0] * 100003


def add(k):
    global ans
    num[arr[k]] += 1
    cnt[num[arr[k]] - 1] -= 1
    cnt[num[arr[k]]] += 1
    ans = max(ans, num[arr[k]])


def sub(k):
    global ans
    num[arr[k]] -= 1
    cnt[num[arr[k]] + 1] -= 1
    cnt[num[arr[k]]] += 1
    if cnt[num[arr[k]] + 1] == 0 and num[arr[k]] + 1 == ans:
        ans -= 1


x = y = 0
ans = 0
for idx, q in enumerate(sorted(queries, key=lambda x: (x[0] // sqrt_n, x[1]))):
    l, r = q[0] - 1, q[1] - 1
    if idx == 0:
        x = l
        y = l - 1
    while y < r:
        y += 1
        add(y)
    while y > r:
        sub(y)
        y -= 1
    while x > l:
        x -= 1
        add(x)
    while x < l:
        sub(x)
        x += 1

    q.append(ans)

print(*map(lambda x: x[-1], queries), sep='\n')
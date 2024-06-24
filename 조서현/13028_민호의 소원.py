import sys

n, m = map(int, sys.stdin.readline().split())
arr = list(map(int, sys.stdin.readline().split()))
queries = [list(map(int, sys.stdin.readline().split())) for _ in range(m)]

sqrt_n = int(n ** 0.5)
num = [0] * 100002
cnt = [0] * 100002


def add(k):
    global ans
    num[arr[k]] += 1
    cnt[num[arr[k]] - 1] -= 1
    cnt[num[arr[k]]] += 1
    if num[arr[k]] == 3:
        ans += 1


def sub(k):
    global ans
    num[arr[k]] -= 1
    cnt[num[arr[k]] + 1] -= 1
    cnt[num[arr[k]]] += 1
    if num[arr[k]] == 2:
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
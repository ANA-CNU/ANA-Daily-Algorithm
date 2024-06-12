import sys

n, m = map(int, sys.stdin.readline().split())
arr = list(map(int, sys.stdin.readline().split()))
queries = [list(map(int, sys.stdin.readline().split())) for _ in range(m)]

sqrt_n = int(n ** 0.5)

# 좌표 압축
compressed = dict()
num = 1
for e in sorted(arr):
    if e not in compressed.keys():
        compressed[e] = num
        num += 1

for i in range(n):
    arr[i] = compressed[arr[i]]

b = [0] * 500002    # 숫자의 개수
cnt = [0] * 500002  # 개수의 개수


def add(k):
    b[arr[k]] += 1
    cnt[b[arr[k]] - 1] -= 1
    cnt[b[arr[k]]] += 1


def sub(k):
    b[arr[k]] -= 1
    cnt[b[arr[k]] + 1] -= 1
    cnt[b[arr[k]]] += 1


x = y = 0
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

    q.append(cnt[2])

print(*map(lambda x: x[-1], queries), sep='\n')
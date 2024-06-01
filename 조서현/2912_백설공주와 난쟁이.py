import sys

# sys.stdin = open('tools/in.txt', 'r')
# sys.stdout = open('tools/out2.txt', 'w')

n, c = map(int, sys.stdin.readline().split())
arr = list(map(int, sys.stdin.readline().split()))
m = int(sys.stdin.readline())
queries = [list(map(int, sys.stdin.readline().split())) for _ in range(m)]

sqrt_n = int(n ** 0.5)
color = [0] * (c + 2) # 범위 내 해당 색깔의 개수
cnt = [0] * (n + 2) # 범위 내 개수의 개수


def add(k):
    color[arr[k]] += 1
    cnt[color[arr[k]] - 1] -= 1
    cnt[color[arr[k]]] += 1


def sub(k):
    color[arr[k]] -= 1
    cnt[color[arr[k]] + 1] -= 1
    cnt[color[arr[k]]] += 1


x = y = 0
for idx, q in enumerate(sorted(queries, key=lambda x: (x[0] // sqrt_n, x[1]))):
    l, r = q[0] - 1, q[1] - 1
    gap = (r - l + 1) >> 1
    if idx == 0:
        x = y = l
        color[arr[x]] += 1
        cnt[color[arr[x]]] += 1
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
    for i in range(1, len(color)):
        if gap < color[i]:
            q.append(f'yes {i}')
            break
    else:
        q.append('no')

print(*map(lambda x: x[-1], queries), sep='\n')
def find(x):
    if parent[x] != x:
        parent[x] = find(parent[x])
        return parent[x]
    return x


def union(x, y):
    px, py = find(x), find(y)
    if px == py:
        return
    if px > py:
        x, y, px, py = y, x, py, px
    parent[y] = x


g, p = int(input()), int(input())
arr = [int(input()) - 1 for _ in range(p)]
parent = [i for i in range(g)]
# used = [False] * g
used_zero = False
cnt = 0
for plane in arr:
    gate = find(plane)
    if gate == 0:
        if used_zero:
            break
        used_zero = True
    else:
        union(gate - 1, plane)
        union(gate - 1, gate)
    cnt += 1
print(cnt)
# https://www.acmicpc.net/problem/10775
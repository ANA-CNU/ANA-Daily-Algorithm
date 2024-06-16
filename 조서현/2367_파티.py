import sys
from collections import deque

OFFSET = 200
MAX = (OFFSET + 1) * 2
n, k, d = map(int, input().split())
src, sink = MAX - 1, MAX - 2

adj = [list[int]() for _ in range(MAX)]
cap = [[0] * MAX for _ in range(MAX)]
flw = [[0] * MAX for _ in range(MAX)]

for i, dish in enumerate(map(int, input().split())):
    adj[i + OFFSET].append(sink)
    cap[i + OFFSET][sink] = dish

for i in range(n):
    adj[src].append(i)
    cap[src][i] = k
    _, *menus = map(int, input().split())
    for menu in menus:
        menu += OFFSET - 1
        adj[i].append(menu)
        adj[menu].append(i)
        cap[i][menu] = 1

res = 0
while True:
    parent = [-1] * MAX
    q = deque([src])
    while q and parent[sink] == -1:
        cur = q.popleft()
        for nxt in adj[cur]:
            if cap[cur][nxt] - flw[cur][nxt] > 0 and parent[nxt] == -1:
                parent[nxt] = cur
                q.append(nxt)

    if parent[sink] == -1:
        break

    p = sink
    while p != src:
        flw[parent[p]][p] += 1
        flw[p][parent[p]] -= 1
        p = parent[p]
    res += 1

print(res)
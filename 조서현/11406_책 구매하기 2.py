from sys import stdin, maxsize
from collections import deque

n, m = map(int, stdin.readline().split())
MAX_MN = max(m, n)
MAX = (MAX_MN + 1) * 2
src, sink = MAX - 1, MAX - 2

adj = [list[int]() for _ in range(MAX)]
cap = [[0] * MAX for _ in range(MAX)]
flw = [[0] * MAX for _ in range(MAX)]

for i, c in enumerate(map(int, stdin.readline().split())):
    adj[src].append(i)
    adj[i].append(src)
    cap[src][i] = c
for i, c in enumerate(map(int, stdin.readline().split())):
    i += MAX_MN
    adj[i].append(sink)
    adj[sink].append(i)
    cap[i][sink] = c
for i in range(m):
    i += MAX_MN
    for j, c in enumerate(map(int, stdin.readline().split())):
        adj[i].append(j)
        adj[j].append(i)
        cap[j][i] = c

cnt = 0
while True:
    parent = [-1] * MAX
    parent[src] = src
    q = deque([src])
    while q and parent[sink] == -1:
        cur = q.popleft()
        for nxt in adj[cur]:
            if cap[cur][nxt] - flw[cur][nxt] > 0 and parent[nxt] == -1:
                parent[nxt] = cur
                q.append(nxt)

    if parent[sink] == -1:
        break

    amount = maxsize
    p = sink
    while p != src:
        amount = min(cap[parent[p]][p] - flw[parent[p]][p], amount)
        p = parent[p]
    p = sink
    while p != src:
        flw[parent[p]][p] += amount
        flw[p][parent[p]] -= amount
        p = parent[p]
    cnt += amount

print(cnt)
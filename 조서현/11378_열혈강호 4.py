from collections import deque

n, m, k = map(int, input().split())
can = []
for i in range(n):
    _, *works = map(lambda x: int(x) - 1, input().split())
    can.append(set(works))

ans = 0

MAX = max(n, m) * 2 + 3
src, sink, bridge = MAX - 1, MAX - 2, MAX - 3
cap = [[0] * MAX for _ in range(MAX)]
flw = [[0] * MAX for _ in range(MAX)]

cap[src][bridge] = k
for i in range(n):
    cap[src][i] = 1
    cap[bridge][i] = k
    for j in can[i]:
        cap[i][j + max(n, m)] = 1
for i in range(m):
    cap[i + max(n, m)][sink] = 1

while True:
    parent = [-1] * MAX
    parent[src] = src
    q = deque([src])

    while q and parent[sink] == -1:
        cur = q.popleft()
        for nxt, c in enumerate(cap[cur]):
            if c - flw[cur][nxt] > 0 and parent[nxt] == -1:
                parent[nxt] = cur
                q.append(nxt)

    if parent[sink] == -1:
        break

    p = sink
    while p != src:
        flw[parent[p]][p] += 1
        flw[p][parent[p]] -= 1
        p = parent[p]
    ans += 1

print(ans)
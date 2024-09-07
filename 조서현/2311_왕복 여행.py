import sys
from collections import deque

N, M = map(int, sys.stdin.readline().split())
MAX = N << 1
src, sink = 1, MAX - 1
adj = [[] for _ in range(MAX + 1)]
cst = [[0] * (MAX + 1) for _ in range(MAX + 1)]
cap = [[0] * (MAX + 1) for _ in range(MAX + 1)]
flw = [[0] * (MAX + 1) for _ in range(MAX + 1)]

def add_edge(u, v, cp, wt):
    adj[u].append(v)
    adj[v].append(u)
    cst[u][v] = wt
    cst[v][u] = -wt
    cap[u][v] = cp

for i in range(1, N):
    v_in, v_out = i << 1, i << 1 | 1
    add_edge(v_in, v_out, 2, 0)

for _ in range(M):
    u, v, w = map(int, sys.stdin.readline().split())
    u_out, v_in = (u - 1) << 1 | 1, (v - 1) << 1
    v_out, u_in = (v - 1) << 1 | 1, (u - 1) << 1
    add_edge(u_out, v_in, 1, w)
    add_edge(v_out, u_in, 1, w)

ans = 0
for _ in range(2):
    parent = [-1] * (MAX + 1)
    parent[src] = src
    dist = [sys.maxsize] * (MAX + 1)
    dist[src] = 0

    q = deque([src])
    in_queue = [False] * (MAX + 1)
    while q:
        cur = q.popleft()
        in_queue[cur] = False
        for nxt in adj[cur]:
            if cap[cur][nxt] - flw[cur][nxt] > 0 and dist[cur] + cst[cur][nxt] < dist[nxt]:
                dist[nxt] = dist[cur] + cst[cur][nxt]
                parent[nxt] = cur
                if not in_queue[nxt]:
                    q.append(nxt)
                    in_queue[nxt] = True

    # if parent[sink] == -1:
    #     break

    p = sink
    while p != src:
        ans += cst[parent[p]][p]
        flw[parent[p]][p] += 1
        flw[p][parent[p]] -= 1
        p = parent[p]

print(ans)
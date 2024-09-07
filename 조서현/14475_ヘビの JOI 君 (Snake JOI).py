import sys
from heapq import heappush, heappop

n, m, x = map(int, sys.stdin.readline().split())
t = [0] + [int(sys.stdin.readline()) for _ in range(n)]
g = [[] for _ in range(n + 1)]
for _ in range(m):
    u, v, w = map(int, sys.stdin.readline().split())
    g[u].append((v, w))
    g[v].append((u, w))

# dists[i][j][k]:
# 가장 마지막으로 온도가 k인 방에서 나온 후 j분이 지났을 때,
# i번 방에 도착하는 최소 시간
dists = [[[sys.maxsize] * 3 for _ in range(x + 1)] for _ in range(n + 1)]
dists[1][0][0] = 0
pq = [(0, 0, 0, 1)] # 거리, 지난 시간, 마지막 온도, 방 번호
while pq:
    d, elapsed, last_tp, u = heappop(pq)
    if dists[u][elapsed][last_tp] < d: continue
    for v, w in g[u]:
        nt = t[v]
        if abs(nt - last_tp) > 1: # 1 -> 3 or 3 -> 1
            if elapsed + w >= x and dists[v][0][nt] > d + w:
                dists[v][0][nt] = d + w
                heappush(pq, (d + w, 0, nt, v))
        elif abs(nt - last_tp) == 1: # 1 -> 2 or 3 -> 2
            if dists[v][min(elapsed + w, x)][last_tp] > d + w:
                dists[v][min(elapsed + w, x)][last_tp] = d + w
                heappush(pq, (d + w, min(elapsed + w, x), last_tp, v))
        else: # 1 -> 1 or 2 -> 2 or 3 -> 3
            if dists[v][0][last_tp] > d + w:
                dists[v][0][last_tp] = d + w
                heappush(pq, (d + w, 0, last_tp, v))

print(min([min(dists[n][i]) for i in range(x + 1)]))
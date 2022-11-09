import sys, heapq

INF = sys.maxsize
V = int(input())
E = int(input())
G = [[] for _ in range(V)]
dp = [INF for _ in range(V)]
q = []

for i in range(E):
    a, b, c = map(int, input().split())
    G[a-1].append((b-1, c))

P1, P2 = map(int, input().split())
P1 -= 1
P2 -= 1

heapq.heappush(q, (0, P1))
while q:
    cw, cn = heapq.heappop(q)
    if dp[cn] < cw:
        continue

    for n, w in G[cn]:
        nw = cw+w
        if nw < dp[n]:
            dp[n] = nw
            heapq.heappush(q, (nw, n))

print(dp[P2])
    
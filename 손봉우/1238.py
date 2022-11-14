import sys, heapq

INF = sys.maxsize
V, E, X = map(int, input().split())
G = [[] for i in range(V)]
X -= 1

for _ in range(E):
    u, v, w = map(int, input().split())
    G[u-1].append((w, v-1))

def dijkstra(start):
    dp = [INF]*(V)
    dp[start] = 0
    q = []
    heapq.heappush(q, (0, start))

    while q:
        cw, cn = heapq.heappop(q)

        if dp[cn] < cw:
            continue
        
        for w, n in G[cn]:
            nw = w + cw
            if nw < dp[n]:
                dp[n] = nw
                heapq.heappush(q, [nw, n])
    return dp

res = 0

for i in range(V):
    c1 = dijkstra(i)
    c2 = dijkstra(X)
    res = max(res, c1[X]+c2[i])

print(res)
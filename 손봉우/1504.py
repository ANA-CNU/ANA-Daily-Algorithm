import sys, heapq

INF = sys.maxsize
V, E = map(int, input().split())
G = [[] for i in range(V)]

for _ in range(E):
    u, v, w = map(int, input().split())
    G[u-1].append((w, v-1))
    G[v-1].append((w, u-1))
SP, EP = map(int, input().split())
SP -= 1
EP -= 1

def dijkstra(start):
    dp = [INF]*(V)
    dp[start] = 0
    q = []
    heapq.heappush(q, (0, start))

    while q:
        cw, cn = heapq.heappop(q)

        if dp[cn] < cw: continue
        
        for w, n in G[cn]:
            nw = w + cw
            if nw < dp[n]:
                dp[n] = nw
                heapq.heappush(q, [nw, n])
    return dp

d_0 = dijkstra(0)
d_sp = dijkstra(SP)
d_ep = dijkstra(EP)

res = min(d_0[SP]+d_sp[EP]+d_ep[V-1], d_0[EP]+d_ep[SP]+d_sp[V-1])

print (res if res < INF else -1)
import sys, heapq

INF = sys.maxsize
V, E, K = map(int, input().split())
G = [[] for i in range(V)]
for _ in range(E):
    u, v, w = map(int, input().split())
    G[u-1].append((v-1, w))

def dijkstra(start):
    dp = [[INF]*K for _ in range(V)]
    dp[start][0] = 0
    q = []
    heapq.heappush(q, (0, start))

    while q:
        w, n = heapq.heappop(q)
        
        for n_n, wei in G[n]:
            n_w = wei + w
            if n_w < dp[n_n][K-1]:
                dp[n_n][K-1] = n_w
                dp[n_n].sort()
                heapq.heappush(q, (n_w, n_n))
    return dp

for i in dijkstra(0):
    if i[K-1] == INF:
        print (-1)
    else:
        print(i[K-1])
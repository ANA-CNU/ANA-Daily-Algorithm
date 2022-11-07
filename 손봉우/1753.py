import heapq

V, E = map(int, input().split())
G = [[] for i in range(V)]
start = int(input())

def dijkstra(graph, start):
    dp = [float('inf')]*(V)
    dp[start] = 0
    q = []
    heapq.heappush(q, (0, start))

    while q:
        wei, cur = heapq.heappop(q)

        if dp[cur] < wei:
            continue
        
        for w, n in graph[cur]:
            nw = w + wei
            if nw < dp[n]:
                dp[n] = nw
                heapq.heappush(q, [nw, n])
    return dp

for _ in range(E):
    u, v, w = map(int, input().split())
    G[u-1].append((w, v-1))

for i in dijkstra(G, start-1):
    print ('INF' if i==float('inf') else i)
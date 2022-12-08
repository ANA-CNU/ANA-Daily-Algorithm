import sys

INF = sys.maxsize
N, M = map(int, input().split())
G = [[] for _ in range(N)]
for _ in range(M):
    u, v, w = map(int, input().split())
    G[u-1].append((v-1, w))

route = [0]*N
D = [-INF]*N
D[0] = 0

def bellman_ford():
    for i in range(N):
        for u in range(N):
            for v, w in G[u]:
                if D[u] != -INF and D[v] < D[u]+w:
                    D[v] = D[u]+w
                    route[v] = u+1
                    if i == N-1:
                        D[v] = INF
    return False

bellman_ford()
print (D)
if D[N-1] == INF:
    print (-1)
else:
    res = []
    i = N
    while True:
        res.append(i)
        i = route[i-1]
        if i == 0: break
    print (*res[::-1])
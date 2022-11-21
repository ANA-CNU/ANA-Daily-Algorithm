import sys
INF = sys.maxsize
N, M = map(int, input().split())

G = [[INF]*N for _ in range(N)]

for _ in range(M):
    a, b, c = map(int, input().split())
    G[a-1][b-1] = c

def floyd_warshall():
    for k in range(N):
        for i in range(N):
            for j in range(N):

                G[i][j] = min(G[i][j], G[i][k]+G[k][j])
    return G

ans = INF
G = floyd_warshall()

for i in range(N):
    ans = min(ans, G[i][i])

print (ans if ans != INF else -1)
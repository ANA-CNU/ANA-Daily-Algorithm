import sys
N = int(input())
M = int(input())

INF = sys.maxsize

G = [[INF]*N for _ in range(N)]

for _ in range(M):
    a, b, c = map(int, input().split())
    G[a-1][b-1] = min(G[a-1][b-1], c)

for k in range(N):
    G[k][k] = 0
    for i in range(N):
        for j in range(N):
            if G[i][j] > G[i][k]+G[k][j]:
                G[i][j] = G[i][k]+G[k][j]

for i in range(N):
    for j in range(N):
        if G[i][j] == INF:
            print (0, end= ' ')
        else:
            print (G[i][j], end=' ')
    print()
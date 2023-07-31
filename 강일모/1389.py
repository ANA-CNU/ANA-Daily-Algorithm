#2583
import sys

INF = 10000

def floyd_warshall(dist):

    for i in range(1, N+1):
        for j in range(1, N+1):
            if i == j:
                dist[i][j] = 0

    for k in range(1, N+1):
        for i in range(1, N+1):
            for j in range(1, N+1):
                if dist[i][j] > (dist[i][k] + dist[k][j]):
                    dist[i][j] = dist[i][k] + dist[k][j]

N, M = map(int, input().split())
dist = [[INF for _ in range(N+1)] for _ in range(N+1)]

for _ in range(M):
    A, B = map(int, input().split())
    dist[A][B], dist[B][A] = 1, 1

floyd_warshall(dist)

dist = list(map(lambda x : sum(x[1:]), dist))

print(dist.index(min(dist)))

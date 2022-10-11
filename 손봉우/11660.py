import sys

N, M = map(int, input().split())
L = [[0]*(N+1)]

for i in range(N):
    L.append([0]+list(map(int, input().split())))

for i in range(1, N+1):
    for j in range(1, N+1):
        L[i][j] += L[i][j-1]
for j in range(1, N+1):
    for i in range(1, N+1):
        L[i][j] += L[i-1][j]

for _ in range(M):
    x1, y1, x2, y2 = map(int, sys.stdin.readline().split())
    print (L[x2][y2]-L[x1-1][y2]-L[x2][y1-1]+L[x1-1][y1-1])
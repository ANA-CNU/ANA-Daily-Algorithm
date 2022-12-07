import sys, heapq

INF = sys.maxsize
N = int(input())
D = [[INF]*N for _ in range(N)]
dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]

L = [list(map(int, list(input()))) for _ in range(N)]


def dijkstra():
    q = []
    heapq.heappush(q, (0, 0, 0))

    while q:
        cx, cy, c = heapq.heappop(q)
        for i in range(4):
            nx = cx + dx[i]
            ny = cy + dy[i]
            if 0 <= nx < N and 0 <= ny < N:
                n = int(not L[nx][ny]) + c
                if n < D[nx][ny]:
                    D[nx][ny] = n
                    heapq.heappush(q, (nx, ny, n))

dijkstra()
print (D[N-1][N-1])
    
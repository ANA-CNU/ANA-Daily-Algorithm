import sys, heapq
M, N = map(int, input().split())
INF = sys.maxsize
MAP = [list(map(int, list(input()))) for _ in range(N)]

dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]

def dijkstra():
    q = []
    heapq.heappush(q, (MAP[0][0], 0, 0))

    while q:
        cw, cx, cy = heapq.heappop(q)

        for i in range(4):
            nx = cx + dx[i]
            ny = cy + dy[i]

            if 0 <= nx < N and 0 <= ny < M:
                nw = cw + MAP[nx][ny]
                if nw < D[nx][ny]:
                    D[nx][ny] = nw
                    heapq.heappush(q, (nw, nx, ny))
    

D = [[INF]*M for _ in range(N)]
dijkstra()
print (0 if D[N-1][M-1] == INF else D[N-1][M-1])

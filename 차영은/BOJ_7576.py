from collections import deque
import sys


def bfs():
    while queue:
        x, y = queue.popleft()

        for i in range(4):
            nx = dx[i] + x
            ny = dy[i] + y

            if 0 <= nx < n and 0 <= ny < m and graph[nx][ny] == 0:
                graph[nx][ny] = graph[x][y] + 1
                queue.append([nx, ny])


m, n = map(int, sys.stdin.readline().split())

graph = [
    list(map(int, sys.stdin.readline().split()))
    for _ in range(n)
]

queue = deque()
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]
ans = 0

for i in range(n):
    for j in range(m):
        if graph[i][j] == 1:
            queue.append([i, j])

bfs()

for i in graph:
    for j in i:
        if j == 0:
            print(-1)
            exit(0)

    ans = max(ans, max(i))

print(ans - 1)

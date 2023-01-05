import sys

sys.setrecursionlimit(10000)


def dfs(x, y):
    graph[x][y] = -1

    for i in range(4):
        nx = dx[i] + x
        ny = dy[i] + y

        if 0 <= nx < n and 0 <= ny < m and graph[nx][ny] == 1:
            graph[nx][ny] = -1
            dfs(nx, ny)


T = int(sys.stdin.readline())

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

for _ in range(T):
    m, n, k = map(int, sys.stdin.readline().split())
    graph = [
        [0] * m
        for _ in range(n)
    ]
    ans = 0

    for _ in range(k):
        x, y = map(int, sys.stdin.readline().split())
        graph[y][x] = 1

    for i in range(n):
        for j in range(m):
            if graph[i][j] == 1:
                dfs(i, j)
                ans += 1

    print(ans)

import sys
from collections import deque

input = sys.stdin.readline
N, M, K = map(int, input().split())
board = [[0] * M for _ in range(N)]
visited = [[False] * M for _ in range(N)]
cnt = 0
dx, dy = [1, -1, 0, 0], [0, 0, 1, -1]
for _ in range(K):
    y1, x1, y2, x2 = map(int, input().split())
    for i in range(x1, x2):
        for j in range(y1, y2):
            board[i][j] = 1


def BFS(x, y):
    que = deque([[x, y]])
    visited[x][y] = True
    ans = 1
    while que:
        nx, ny = que.popleft()
        for i in range(4):
            mx, my = nx + dx[i], ny + dy[i]
            if 0 <= mx < N and 0 <= my < M and \
                    board[mx][my] == 0 and not visited[mx][my]:
                visited[mx][my] = True
                que.append([mx, my])
                ans += 1
    return ans

ans = []

for i in range(N):
    for j in range(M):
        if not visited[i][j] and board[i][j] == 0:
            cnt += 1
            ans.append(BFS(i, j))

print(cnt)
print(*sorted(ans))

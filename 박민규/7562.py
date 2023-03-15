#백준 7562번 나이트
from collections import deque
import sys
input = sys.stdin.readline


dx = [1,1,-1,-1,2,2,-2,-2]
dy = [2,-2,2,-2,1,-1,1,-1]

def bfs(x1,y1,x2,y2):
    q = deque()
    q.append((x1,y1))
    visited[x1][y1] = 1

    while q:
        x,y = q.popleft()
        if x == x2 and y == y2:
            return dist[x][y]
        for i in range(8):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0<= nx < n and 0<= ny <n and not visited[nx][ny]:
                visited[nx][ny] = 1
                dist[nx][ny] = dist[x][y] + 1
                q.append((nx,ny))

t = int(input())
for i in range(t):
    n = int(input())
    x1,y1 = map(int,input().split())
    x2,y2 = map(int,input().split())

    visited = [[0]*n for _ in range(n)]
    dist = [[0]*n for _ in range(n)]

    print(bfs(x1,y1,x2,y2))
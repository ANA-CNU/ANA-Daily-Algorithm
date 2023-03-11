# 백준 2178번 미로탐색
import sys
from collections import deque
input = sys.stdin.readline

def bfs(x,y):
    q = deque()
    q.append((x,y))

    while q:
        x,y = q.popleft()
        for i in range(4):
            nx,ny = x+dx[i], y+dy[i]

            if 0 <= nx < n and 0 <= ny <m and maze[nx][ny] == 1:
                q.append((nx,ny))
                maze[nx][ny] = maze[x][y] +1

n,m = map(int,input().split())
dx = [1,0,-1,0]
dy = [0,1,0,-1]
maze = [list(map(int,input().strip())) for _ in range(n)]
bfs(0,0)
print(maze[n-1][m-1])
#백준 7576번 토마토
from collections import deque
import sys
input = sys.stdin.readline
visited = []
m,n = map(int,input().split())
for i in range(n):
    visited.append(list(map(int,input().split())))
           
dx = [1,-1,0,0]
dy = [0,0,-1,1]

def bfs():
    q = deque()
    for i in range(n):
        for j in range(m):
            if visited[i][j] == 1:
                q.append((i,j))

    while q:
        x,y = q.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0<= nx < n and 0<= ny <m and visited[nx][ny] == 0:
                q.append((nx,ny))
                visited[nx][ny] = visited[x][y] + 1

bfs()
cnt = 0
for i in range(n):
    for j in range(m):
        if visited[i][j] == 0:
            print(-1)
            exit(0)
        cnt = max(cnt, visited[i][j])
print(cnt-1)
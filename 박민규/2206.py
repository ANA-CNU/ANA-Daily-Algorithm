#백준 2206번 벽 부수고 이동하기
from collections import deque
import sys
input = sys.stdin.readline

n,m = map(int,input().split())
graph = [list(map(int,input().strip())) for _ in range(n)]
visited = [[[0 for _ in range(m)] for _ in range(n)] for _ in range(2)]
visited[0][0][0] = 1
dx = [1,-1,0,0]
dy = [0,0,1,-1]

def bfs(x,y,z):
    q = deque()
    q.append((x,y,z))

    while q:
        x,y,z = q.popleft()

        for i in range(4):
            nx,ny = x+dx[i],y+dy[i]
            if 0<= ny < n and 0<= nx <m:
                if graph[ny][nx] == 0 and visited[z][ny][nx] == 0:  #벽 부수기 x
                    visited[z][ny][nx] = visited[z][y][x] +1
                    q.append((nx,ny,z))
                elif graph[ny][nx] == 1 and z == 0:   #벽부수기 o
                    visited[1][ny][nx] = visited[z][y][x] + 1
                    q.append((nx,ny,1))
    
    if visited[0][-1][-1] == 0 and visited[1][-1][-1] == 0:    #visited[z][-1][-1]  가장 오른쪽 아래의 위치 방문 여부
        return -1
    elif visited[0][-1][-1] != 0 and visited[1][-1][-1] == 0:  #visited[0][-1][-1] 벽을 깨지 않고 도착지점에 도달한 경우
        return visited[0][-1][-1]
    elif visited[0][-1][-1] == 0 and visited[1][-1][-1] != 0:  ##visited[1][-1][-1] 벽을 깨고 도착지점에 도달한 경우
        return visited[1][-1][-1]
    else:
        return min(visited[0][-1][-1], visited[1][-1][-1])
    
print(bfs(0,0,0))
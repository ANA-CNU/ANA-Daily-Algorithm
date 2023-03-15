# 백준 7569번 3차원 토마토
from collections import deque
import sys
input = sys.stdin.readline
m,n,h = map(int,input().split())
tmt = [[list(map(int,input().split())) for _ in range(n)] for _ in range(h)]
dx = [1,-1,0,0,0,0]
dy = [0,0,1,-1,0,0]
dz = [0,0,0,0,1,-1]

def bfs():
    q = deque()
    for i in range(h):
        for j in range(n):
            for k in range(m):
                if tmt[i][j][k] == 1:
                    q.append((i,j,k,0))

    while q:
        z,y,x,day = q.popleft()
        for i in range(6):
            nx,ny,nz = x + dx[i],y + dy[i],z + dz[i]
            if 0<= nx <m and 0<= ny <n and 0<= nz <h:
                if tmt[nz][ny][nx] == 0:
                    tmt[nz][ny][nx] = 1
                    q.append((nz,ny,nx,day+1))

    for i in range(h):  
        for j in range(n):
            for k in range(m):
                if tmt[i][j][k] == 0:
                    return -1
    return day

print(bfs())
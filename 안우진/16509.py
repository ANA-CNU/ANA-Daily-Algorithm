# BOJ 16509

from collections import deque
dx=[(0,-1),(0,1),(1,1),(1,1),(-1,-1),(-1,-1),(0,-1),(0,1)]
dy=[(-1,-1),(-1,-1),(0,1),(0,-1,),(0,1),(0,-1),(1,1),(1,1)]
d=[[0]*9 for _ in range(10)]
sy,sx=map(int,input().split())
ky,kx=map(int,input().split())
q=deque([(sy,sx)]) # r,c
d[sy][sx]=1
d[ky][kx]=-1
while q:
    sy,sx=q.popleft()
    for i in range(8):
        ny,nx=sy,sx
        flag=1
        for j in range(2):
            nx+=dx[i][j];ny+=dy[i][j]
            if not (0<=nx<9 and 0<=ny<10 and d[ny][nx]!=-1):
                flag=0
                break
        if not flag: continue
        nx+=dx[i][1]; ny+=dy[i][1]
        if 0<=nx<9 and 0<=ny<10 and d[ny][nx]<1:
            if nx==kx and ny==ky:
                print(d[sy][sx])
                exit()
            d[ny][nx]=d[sy][sx]+1
            q.append((ny,nx))
print(-1)

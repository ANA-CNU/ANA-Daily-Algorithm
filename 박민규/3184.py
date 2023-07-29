# 백준 3184번 양
from collections import deque
import sys
input = sys.stdin.readline

r,c = map(int,input().split())
a = [input().rstrip() for _ in range(r)]
visited = [[False]*c for _ in range(r)]
sheep,wolf = 0,0

def bfs(i,j):
    global sheep
    global wolf
    s,w = 0,0 
    b = deque([[i,j]])  
    while b:
        x,y=b.popleft()
        if a[x][y] == 'v':
            w += 1
        elif a[x][y] == 'o':
            s += 1
        if x+1<r and not visited[x+1][y] and a[x+1][y] !='#':
            visited[x+1][y]=True
            b.append([x+1,y])
        if x-1>=0 and not visited[x-1][y] and a[x-1][y] !='#':
            visited[x-1][y]=True
            b.append([x-1,y])
        if y+1<c and not visited[x][y+1] and a[x][y+1] !='#' :
            visited[x][y+1]=True
            b.append([x,y+1])
        if y-1>=0 and not visited[x][y-1] and a[x][y-1] !='#':
            visited[x][y-1]=True
            b.append([x,y-1])
    if s > w:
        sheep += s
    else:
        wolf += w
for i in range(r):
    for j in range(c):
        if not visited[i][j] and a[i][j] != '#':
            visited[i][j] = True
            bfs(i,j)

print(sheep,wolf)
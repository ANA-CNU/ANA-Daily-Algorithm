#백준 1012번 유기농 배추
import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline

t = int(input())

def dfs(x,y):
    if x<0 or x>=m or y<0 or y>=n:
        return
    if graph[x][y] == 0:
        return
    
    graph[x][y] = 0

    dfs(x+1,y)
    dfs(x,y+1)
    dfs(x-1,y)
    dfs(x,y-1)

for _ in range(t):
    n,m,k = map(int,input().split())
    graph = [[0]*n for _ in range(m)]
    cnt = 0
    for i in range(k):
        a,b = map(int,input().split())
        graph[b][a] = 1

    for i in range(m):
        for j in range(n):
            if graph[i][j] == 1:
                dfs(i,j)
                cnt += 1
    print(cnt)
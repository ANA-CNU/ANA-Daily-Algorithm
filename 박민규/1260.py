# 백준 1260번
from collections import deque
import sys
input = sys.stdin.readline

def bfs(v):
    q = deque()
    q.append(v)
    visit_1[v] = 1
    while q:
        v = q.popleft()
        print(v,end=' ')
        for i in range(1,n+1):
            if visit_1[i] == 0 and graph[v][i] == 1:
                q.append(i)
                visit_1[i] = 1

def dfs(v):
    visit_2[v] = 1
    print(v,end=" ")
    for i in range(1,n+1):
        if visit_2[i] == 0 and graph[v][i] == 1:
            dfs(i)

n,m,v = map(int, input().split())
graph = [[0]*(n+1) for _ in range(n+1)]
visit_1 = [0]*(n+1)
visit_2 = [0]*(n+1)

for i in range(m):
    a,b = map(int, input().split())
    graph[a][b] = graph[b][a] =1

dfs(v)
print()
bfs(v)
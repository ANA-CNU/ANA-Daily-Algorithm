# 백준 2606번 바이러스
n = int(input())
m = int(input())

graph = [[] for _ in range(n+1) ]

for i in range(m):
    a,b = map(int,input().split())
    graph[a].append(b)
    graph[b].append(a)

visited = [0]*(n+1)
def dfs (graph, v, visited):
    visited[v] = 1
    for i in graph[v]:
        if visited[i] == 0:
            dfs(graph,i,visited)
dfs(graph,1,visited)
print(sum(visited)-1)
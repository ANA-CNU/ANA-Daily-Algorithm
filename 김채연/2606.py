n = int(input())
m = int(input())
graph = [[] for _ in range(n+1)]
visited = [0]*(n+1)
for _ in range(m):
    a, b = map(int, input().split())
    graph[a]+=[b]
    graph[b]+=[a]

def dfs(nod):
    visited[nod]=1
    for i in graph[nod]:
        if visited[i]==0:
            dfs(i)

dfs(1)
print(sum(visited)-1)

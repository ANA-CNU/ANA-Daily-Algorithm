n, m, v = map(int, input().split())

graph = [[0]*(n+1) for _ in range(n+1)]
for i in range (m):
    a,b = map(int,input().split())
    graph[a][b] = graph[b][a] = 1

visited_Dfs = [0]*(n+1)
visited_Bfs = [0]*(n+1)


def dfs(v):
    visited_Dfs[v] = 1 
    print(v, end=' ')
    for i in range(1, n+1):
        if graph[v][i] == 1 and visited_Dfs[i] == 0:
            dfs(i)


def bfs(v):
    queue = [v]
    visited_Bfs[v] = 1 
    while queue:
        v = queue.pop(0)
        print(v, end = ' ')
        for i in range(1, n+1):
            if(visited_Bfs[i] == 0 and graph[v][i] == 1):
                queue.append(i)
                visited_Bfs[i] = 1 

dfs(v)
print()
bfs(v)

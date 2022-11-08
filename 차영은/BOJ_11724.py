import sys

sys.setrecursionlimit(10000)

def dfs(num):
    visited[num] = 1

    for j in range(1, n + 1):
        if visited[j] == 0 and graph[num][j] == 1:
            dfs(j)


n, m = map(int, sys.stdin.readline().split())
graph = [
    [0] * (n + 1)
    for _ in range(n + 1)
]
visited = [0] * (n + 1)
ans = 0

for i in range(m):
    s, e = map(int, sys.stdin.readline().split())
    graph[s][e] = graph[e][s] = 1

for i in range(1, n + 1):
    if not visited[i]:
        dfs(i)
        ans += 1

print(ans)

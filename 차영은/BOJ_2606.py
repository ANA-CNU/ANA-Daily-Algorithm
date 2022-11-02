import sys


def dfs(num):
    visited[num] = 1

    for i in range(1, n + 1):
        if visited[i] == 0 and graph[num][i] == 1:
            dfs(i)


n = int(sys.stdin.readline())
m = int(sys.stdin.readline())
graph = [[0] * (n + 1) for _ in range(n + 1)]
visited = [0] * (n + 1)
ans = 0

for _ in range(m):
    s, e = map(int, sys.stdin.readline().split())
    graph[s][e] = graph[e][s] = 1

dfs(1)

print(sum(visited) - 1)

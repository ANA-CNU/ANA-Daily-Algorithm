import sys
from collections import deque


def dfs(num):
    dfs_visited[num] = 1
    print(num, end=' ')

    for i in range(1, n + 1):
        if dfs_visited[i] == 0 and graph[num][i] == 1:
            dfs(i)


def bfs(num):
    q = deque()
    q.append(num)
    bfs_visited[num] = 1

    while q:
        tlqkf = q.popleft()
        print(tlqkf, end=' ')

        for i in range(1, n + 1):
            if bfs_visited[i] == 0 and graph[tlqkf][i] == 1:
                q.append(i)
                bfs_visited[i] = 1


n, m, v = map(int, sys.stdin.readline().split())
graph = [[0] * (n + 1) for _ in range(n + 1)]
dfs_visited = [0] * (n + 1)
bfs_visited = [0] * (n + 1)

for _ in range(m):
    s, e = map(int, sys.stdin.readline().split())

    graph[s][e] = 1
    graph[e][s] = 1

dfs(v)
print()
bfs(v)

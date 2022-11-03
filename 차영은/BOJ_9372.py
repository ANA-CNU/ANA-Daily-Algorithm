import sys
from collections import deque


def bfs(num):
    queue = deque()
    queue.append(num)
    visited[num] = 1

    while queue:
        a = queue.popleft()

        for index in range(1, n + 1):
            if visited[index] == 0 and graph[a][index] == 1:
                queue.append(index)
                visited[index] = 1


T = int(sys.stdin.readline())

for _ in range(T):
    n, m = map(int, sys.stdin.readline().split())
    graph = [[0] * (n + 1) for _ in range(n + 1)]
    ans = 0
    visited = [0] * (n + 1)

    for i in range(m):
        s, e = map(int, sys.stdin.readline().split())
        graph[s][e] = graph[e][s] = 1

    bfs(1)
    print(sum(visited) - 1)

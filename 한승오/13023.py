from collections import defaultdict
import sys

sys.setrecursionlimit(10 ** 6)
input = sys.stdin.readline

def dfs(v, cnt, visited):
    if cnt == 4:
        res = True
        return res
    r = False

    for c in graph[v]:
        if r:
            break
        if visited[int(c)]:
            continue

        visited[int(c)] = 1
        r = dfs(c, cnt+1, visited)
        visited[int(c)] = 0
    
    return r

n, m = map(int, input().split())
graph = defaultdict(list)
for _ in range(m):
    a,b = input().split()
    graph[a].append(b)
    graph[b].append(a)

for i in range(n):
    visited = [0]*n
    visited[i] = 1
    out = dfs(str(i), 0, visited)
    if out:
        break

print(int(out))
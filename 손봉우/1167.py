import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline

V = int(input())
G = [[] for _ in range(V)]
for _ in range(V):
    token = list(map(int, input().split()))[:-1]
    for i in range(1, len(token), 2):
        G[token[0]-1].append((token[i]-1, token[i+1]))

def dfs(node, dist):
    global max_node, max_dist
    visited[node] = True
    if dist > max_dist:
        max_node = node
        max_dist = dist
    for n_node, n_dist in G[node]:
        if not visited[n_node]:
            dfs(n_node, dist+n_dist)

max_node = 0

max_dist = 0
visited = [False]*V
dfs(0, 0)
max_dist = 0
visited = [False]*V
dfs(max_node, 0)

print (max_dist)
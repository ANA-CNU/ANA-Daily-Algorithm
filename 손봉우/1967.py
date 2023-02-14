import sys
sys.setrecursionlimit(10**6)
M = int(input())
G = [[] for _ in range(M)]

for _ in range(M-1):
    a, b, c = map(int, input().split())
    G[a-1].append((b-1, c))
    G[b-1].append((a-1, c))

n1 = 0
tmp = 0

def dfs(node, length):
    global n1, tmp
    visit[node] = True
    if length > tmp:
        tmp = length
        n1 = node
    for child, v in G[node]:
        if not visit[child]:
            dfs(child, length+v)

visit = [False]*M
dfs(0, 0)
tmp = 0
visit = [False]*M
dfs(n1, 0)
print (tmp)
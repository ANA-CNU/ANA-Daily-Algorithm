import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline
N, R, Q = map(int, input().split())
G = [[] for _ in range(N)]
cnt = [1]*N
visited = [False]*N

for _ in range(N-1):
    a, b = map(int, input().split())
    G[a-1].append(b-1)
    G[b-1].append(a-1)

def dfs(node):
    visited[node] = True

    for i in G[node]:
        if not visited[i]:
            cnt[node] += dfs(i)
    return cnt[node]

dfs(R-1)

for _ in range(Q):
    print (cnt[int(input())-1])

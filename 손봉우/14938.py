N, M, R = map(int, input().split())

item = list(map(int, input().split()))
G = [[] for _ in range(N)]
for _ in range(R):
    a, b, c = map(int, input().split())
    G[a-1].append((b-1, c))
    G[b-1].append((a-1, c))

def dfs(node, dist):
    global result
    if dist > M:
        return
    if not visit[node]:
        result += item[node]
    visit[node] = True
    
    for n_node, n_dist in G[node]:
        dfs(n_node, dist+n_dist)

max_result = 0

for i in range(N):
    result = 0
    visit = [False]*N
    dfs(i, 0)
    max_result = max(max_result, result)

print (max_result)
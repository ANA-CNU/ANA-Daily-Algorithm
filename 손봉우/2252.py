from collections import deque

N, M = map(int, input().split())

G = [[] for _ in range(N)]
inDegree = [0]*N
q = deque()
ans = []

for i in range(M):
    a, b = map(int, input().split())
    G[a-1].append(b-1)
    inDegree[b-1] += 1

for i in range(N):
    if inDegree[i] == 0:
        q.append(i)

while q:
    cur = q.popleft()
    ans.append(cur+1)
    for i in G[cur]:
        inDegree[i] -= 1
        if inDegree[i] == 0:
            q.append(i)

print (*ans)
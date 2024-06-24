import sys
from collections import deque

n, p = map(int, sys.stdin.readline().split())
MAX = n << 1 | 1
cap = [[0] * MAX for _ in range(MAX)]
flw = [[0] * MAX for _ in range(MAX)]
# a in = a << 1
# a out = a << 1 | 1
# a -> b 용량 = a out -> b in 용량 cap[a << 1 | 1][b << 1]
for _ in range(p):
    a, b = map(lambda x: int(x) - 1, sys.stdin.readline().split())
    cap[a << 1 | 1][b << 1] = 1
    cap[b << 1 | 1][a << 1] = 1 # 양방향 간선
for i in range(n):
    cap[i << 1][i << 1 | 1] = 1
    # 노드 간 in -> out 사이의 용량 설정 (단방향 간선)

total = 0
start = 0 << 1 | 1
dest = 1 << 1
# visited = [False] * n
while True:
    parent = [-1] * MAX
    parent[start] = start
    q = deque([start])

    while q and parent[dest] == -1:
        cur = q.popleft()
        for nxt in range(MAX):
            if cap[cur][nxt] - flw[cur][nxt] > 0 and parent[nxt] == -1:
                # if nxt != 0 and nxt != 1 and visited[nxt]:
                #     continue
                q.append(nxt)
                parent[nxt] = cur

    if parent[dest] == -1:
        break

    amount = sys.maxsize
    p = dest
    while p != start:
        amount = min(cap[parent[p]][p] - flw[parent[p]][p], amount)
        p = parent[p]

    p = dest
    while p != start:
        flw[parent[p]][p] += amount
        flw[p][parent[p]] -= amount
        p = parent[p]

    total += 1

print(total)
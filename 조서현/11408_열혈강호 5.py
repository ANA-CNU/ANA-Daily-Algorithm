import sys
from collections import deque

n, m = map(int, input().split())
MAX = max(n, m) * 2 + 2
src, sink = MAX - 1, MAX - 2
adj = [list[int]() for _ in range(MAX)]
cst = [[0] * MAX for _ in range(MAX)]
cap = [[0] * MAX for _ in range(MAX)]
flw = [[0] * MAX for _ in range(MAX)]

# 유량의 흐름
# 소스 -> 직원 -> 일 -> 싱크

for i in range(m):
    # 일 -> 싱크 간 연결
    cap[i + max(n, m)][sink] = 1
    adj[i + max(n, m)].append(sink)

for i in range(n):
    # 소스 -> 직원 간 연결
    cap[src][i] = 1
    adj[src].append(i)
    # 직원 -> 일 간 연결
    _, *works = map(int, input().split())
    j = 0
    while j < len(works):
        worker, fee = works[j] - 1 + max(n, m), works[j + 1]
        adj[i].append(worker)
        adj[worker].append(i)
        cst[i][worker] = fee
        cst[worker][i] = -fee
        cap[i][worker] = sys.maxsize
        j += 2

cnt = 0
money = 0
while True:
    parents = [-1] * MAX
    dist = [sys.maxsize] * MAX
    dist[src] = 0

    q = deque([src])
    while q:
        cur = q.popleft()
        for nxt in adj[cur]:
            if cap[cur][nxt] - flw[cur][nxt] > 0 and dist[cur] + cst[cur][nxt] < dist[nxt]:
                dist[nxt] = dist[cur] + cst[cur][nxt]
                parents[nxt] = cur
                if nxt not in q:
                    q.append(nxt)

    if parents[sink] == -1:
        break

    p = sink
    while p != src:
        money += cst[parents[p]][p]
        flw[parents[p]][p] += 1
        flw[p][parents[p]] -= 1
        p = parents[p]
    cnt += 1

print(cnt)
print(money)
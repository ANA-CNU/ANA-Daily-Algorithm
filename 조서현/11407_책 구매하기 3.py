from collections import deque
from sys import stdin, maxsize

n, m = map(int, stdin.readline().split())
MAX = (max(n, m) + 1) * 2
src, sink = MAX - 2, MAX - 1

cap = [[0] * MAX for _ in range(MAX)]
flw = [[0] * MAX for _ in range(MAX)]
cst = [[0] * MAX for _ in range(MAX)]
adj = [[] for _ in range(MAX)]

# 유량이 흐르는 경로: 소스 -> 서점 -> 사람 -> 싱크

# 경로           용량(cap)  비용(cst)
# 소스 -> 서점   B_i        0
# 서점 -> 사람   C_ij       D_ij
# 사람 -> 싱크   A_i        0

# 사람 -> 싱크 간 간선/용량 추가 (단방향)
for idx, a in enumerate(map(int, stdin.readline().split())):
    idx += max(n, m)
    cap[idx][sink] = a
    adj[idx].append(sink)
    adj[sink].append(idx)

# 소스 -> 서점 간 간선/용량 추가 (단방향)
for idx, b in enumerate(map(int, stdin.readline().split())):
    cap[src][idx] = b
    adj[src].append(idx)
    adj[idx].append(src)

# 서점 -> 사람 간 간선/용량 추가 (단방향)
for i in range(m):
    for j, c in enumerate(map(int, stdin.readline().split())):
        j += max(n, m)
        cap[i][j] = c
        adj[i].append(j)
        adj[j].append(i)

# 서점 -> 사람 간 배송 비용 추가
for i in range(m):
    for j, d in enumerate(map(int, stdin.readline().split())):
        j += max(n, m)
        cst[i][j] = d
        cst[j][i] = -d # 역방향 간선의 비용은 음수로

books = 0
charge = 0
while True:
    parent = [-1] * MAX
    parent[src] = src
    dist = [maxsize] * MAX
    dist[src] = 0

    q = deque([src])
    # SPFA
    while q:
        cur = q.popleft()
        for nxt in adj[cur]:
            if cap[cur][nxt] - flw[cur][nxt] > 0 and dist[cur] + cst[cur][nxt] < dist[nxt]:
                dist[nxt] = dist[cur] + cst[cur][nxt]
                parent[nxt] = cur
                if nxt not in q:
                    q.append(nxt)

    if parent[sink] == -1:
        break

    amount = maxsize
    p = sink
    while p != src:
        amount = min(cap[parent[p]][p] - flw[parent[p]][p], amount)
        p = parent[p]
    p = sink
    while p != src:
        charge += amount * cst[parent[p]][p]
        flw[parent[p]][p] += amount
        flw[p][parent[p]] -= amount
        p = parent[p]
    books += amount

print(books)
print(charge)
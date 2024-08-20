import sys
from collections import deque

n, m = map(int, sys.stdin.readline().split())
MAX = (n + 2) * 2
src, sink = MAX - 2, MAX - 1

cap = [[0] * MAX for _ in range(MAX)]
adj = [[] for _ in range(MAX)]

# 유량이 흐르는 경로: 소스 -> 현재 약점 -> 이동 후 약점 -> 싱크
# 경로                       용량(cap)
# 소스->현재 약점            A_i
# 현재 약점->이동 후 약점    무한대
# 이동 후 약점->싱크         매개변수로 이분탐색

# 소스 -> 현재 약점
for i, a in enumerate(map(int, sys.stdin.readline().split())):
    cap[src][i] = a
    adj[src].append(i)
    adj[i].append(src)
# 현재 약점 -> 이동 후 약점
for _ in range(m):
    v, u = map(lambda x: int(x) - 1, sys.stdin.readline().split())
    cap[v][u + n] = sys.maxsize
    adj[v].append(u + n)
    adj[u + n].append(v)
    cap[u][v + n] = sys.maxsize
    adj[u].append(v + n)
    adj[v + n].append(u)
for i in range(n):
    j = i + n
    cap[i][j] = sys.maxsize
    adj[i].append(j)
    adj[j].append(i)

# 이동 후 약점 -> 싱크
r = int(sys.stdin.readline())
b = list(map(lambda x: int(x) + n - 1, sys.stdin.readline().split()))
for e in b:
    adj[e].append(sink)
    adj[sink].append(e)

l, r = 0, 100 * 100000 + 10
ans = 0
while l <= r:
    mid = (l + r) // 2
    for e in b:
        cap[e][sink] = mid
    flw = [[0] * MAX for _ in range(MAX)]
    res = 0
    while True:
        parents = [-1] * MAX
        parents[src] = src
        q = deque([src])
        while q and parents[sink] == -1:
            u = q.popleft()
            for v in adj[u]:
                if cap[u][v] - flw[u][v] > 0 and parents[v] == -1:
                    parents[v] = u
                    q.append(v)
        if parents[sink] == -1:
            break
        amount = sys.maxsize
        p = sink
        while p != src:
            amount = min(amount, cap[parents[p]][p] - flw[parents[p]][p])
            p = parents[p]
        p = sink
        while p != src:
            flw[parents[p]][p] += amount
            flw[p][parents[p]] -= amount
            p = parents[p]
        res += amount

    if res == mid * len(b):
        ans = max(ans, mid)
        l = mid + 1
    else:
        r = mid - 1


print(ans)
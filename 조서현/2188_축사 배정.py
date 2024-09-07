from collections import deque

OFFSET = 200
MAX = OFFSET + 1 << 1
n, m = map(int, input().split())

src, sink = MAX - 1, MAX - 2
adj = [list[int]() for _ in range(MAX)]
cap = [[0] * MAX for _ in range(MAX)]
flw = [[0] * MAX for _ in range(MAX)]

for cow in range(n):
    adj[src].append(cow)
    cap[src][cow] = 1
    _, *wants = map(lambda x: int(x) + OFFSET - 1, input().split())
    for want in wants:
        adj[cow].append(want)
        adj[want].append(cow)
        cap[cow][want] = 1

for shed in range(OFFSET, m + OFFSET):
    adj[shed].append(sink)
    cap[shed][sink] = 1

res = 0
while True:
    parent = [-1] * MAX
    q = deque([src])
    while q and parent[sink] == -1:
        cur = q.popleft()
        for nxt in adj[cur]:
            if cap[cur][nxt] - flw[cur][nxt] > 0 and parent[nxt] == -1:
                parent[nxt] = cur
                q.append(nxt)

    if parent[sink] == -1:
        break

    p = sink
    while p != src:
        flw[parent[p]][p] += 1
        flw[p][parent[p]] -= 1
        p = parent[p]
    res += 1

print(res)
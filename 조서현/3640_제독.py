import sys
from collections import defaultdict, deque

while True:
    try:
        v, e = map(int, sys.stdin.readline().split())
        MAX = v << 1
        src, sink = 1, MAX - 2
        adj = defaultdict(list)
        cst = defaultdict(lambda: defaultdict(int))
        cap = defaultdict(lambda: defaultdict(int))
        flw = defaultdict(lambda: defaultdict(int))

        for i in range(1, v):
            v_in, v_out = i << 1, i << 1 | 1
            adj[v_in].append(v_out)
            adj[v_out].append(v_in)
            cap[v_in][v_out] = 1

        for _ in range(e):
            a, b, c = map(int, sys.stdin.readline().split())
            a, b = (a - 1) << 1 | 1, (b - 1) << 1
            adj[a].append(b)
            adj[b].append(a)
            cst[a][b] = c
            cst[b][a] = -c
            cap[a][b] = 1

        total = 0
        for _ in range(2):
            parent = [-1] * (MAX + 1)
            parent[src] = src
            dist = [sys.maxsize] * (MAX + 1)
            dist[src] = 0

            q = deque([src])
            while q:
                cur = q.popleft()
                for nxt in adj[cur]:
                    if cap[cur][nxt] - flw[cur][nxt] > 0 and dist[cur] + cst[cur][nxt] < dist[nxt]:
                        dist[nxt] = dist[cur] + cst[cur][nxt]
                        parent[nxt] = cur
                        if nxt not in q:
                            q.append(nxt)

            # if parent[sink] == -1:
            #     break

            p = sink
            while p != src:
                total += cst[parent[p]][p]
                flw[parent[p]][p] += 1
                flw[p][parent[p]] -= 1
                p = parent[p]

        print(total)

    except:
        break
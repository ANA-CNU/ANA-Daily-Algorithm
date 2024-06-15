import sys
from collections import deque

# sys.stdin = open('tools/testcase.txt', 'r')

n, m = map(int, sys.stdin.readline().split())
MAX_MN = max(n, m)
MAX = 1005
src, sink = MAX - 1, MAX - 2
adj = [list[int]() for _ in range(MAX)]
cap = [[0] * MAX for _ in range(MAX)]
flw = [[0] * MAX for _ in range(MAX)]
cst = [[0] * MAX for _ in range(MAX)]

for i in range(1, n + 1):
	work_count, *works = map(int, sys.stdin.readline().split())
	cap[src][i] = 1
	adj[src].append(i)
	adj[i].append(src)
	for j in range(work_count):
		j, c = MAX_MN + works[j << 1], works[j << 1 | 1]
		cap[i][j] = 1
		cst[i][j] = -c
		cst[j][i] = c
		adj[i].append(j)
		adj[j].append(i)

for i in range(1, m + 1):
	work = i + MAX_MN
	cap[work][sink] = 1
	adj[work].append(sink)
	adj[sink].append(work)

cnt = fee = 0
while True:
	# print(cnt, fee)
	parent = [-1] * MAX
	parent[src] = src
	dist = [sys.maxsize] * MAX
	dist[src] = 0

	q = deque([src])
	in_q = [False] * MAX
	while q:
		cur = q.popleft()
		in_q[cur] = False
		for nxt in adj[cur]:
			if cap[cur][nxt] - flw[cur][nxt] > 0 and dist[cur] + cst[cur][nxt] < dist[nxt]:
				dist[nxt] = dist[cur] + cst[cur][nxt]
				parent[nxt] = cur
				if not in_q[nxt]:
					q.append(nxt)
					in_q[nxt] = True

	if parent[sink] == -1:
		break

	p = sink
	while p != src:
		fee += cst[parent[p]][p]
		flw[parent[p]][p] += 1
		flw[p][parent[p]] -= 1
		p = parent[p]
	cnt += 1

print(cnt)
print(-fee)
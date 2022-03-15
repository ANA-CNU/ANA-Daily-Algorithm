import sys
from collections import defaultdict
n, m = map(int, sys.stdin.readline().split())
d = defaultdict(int)
for _ in range(n):
    w = sys.stdin.readline().strip()
    d[w] += 1
d = list(d.items())
d.sort(key=lambda x:(-x[1], -len(x[0]), x[0]))
for i in d:
    if len(i[0]) < m:
        continue
    print(i[0])
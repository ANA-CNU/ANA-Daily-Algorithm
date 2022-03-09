import sys
from collections import defaultdict
n = int(sys.stdin.readline())
d = defaultdict(int)
for _ in range(n):
    f = sys.stdin.readline().strip().split(".")
    d[f[1]] += 1

d = sorted(d.items())
for i in d:
    print(i[0], i[1])
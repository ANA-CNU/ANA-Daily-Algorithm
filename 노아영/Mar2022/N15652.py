import sys
from itertools import product
n, m = map(int, sys.stdin.readline().split())
ans = []
for i in product(range(1, n+1), repeat=m):
    tmp = sorted(i)
    if list(i) != tmp:
        continue
    for j in i:
        print(j, end=' ')
    print()
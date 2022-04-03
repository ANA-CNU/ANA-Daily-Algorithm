import sys
from itertools import combinations
n, m = map(int, sys.stdin.readline().split())
for i in combinations(range(1, n+1), m):
    tmp = sorted(i)
    if list(i) != tmp:
        continue
    for j in i:
        print(j, end =' ')
    print()
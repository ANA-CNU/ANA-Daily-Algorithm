import sys
from itertools import combinations

n, m = map(int, sys.stdin.readline().split())
arr = [i for i in range(1, n + 1)]
ans = list(combinations(arr, m))

for i in ans:
    print(*i)

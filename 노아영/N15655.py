import sys
from itertools import combinations
n, m = map(int, sys.stdin.readline().split())
nums = list(map(int, sys.stdin.readline().split()))
a = []
for i in combinations(nums, m):
    a.append(sorted(i))
a.sort()
for j in a:
    for k in j:
        print(k, end=" ")
    print()
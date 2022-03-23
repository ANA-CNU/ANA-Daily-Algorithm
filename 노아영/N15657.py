import sys
from itertools import combinations_with_replacement
n, m = map(int, sys.stdin.readline().split())
nums = list(map(int, sys.stdin.readline().split()))
ans = []
for i in combinations_with_replacement(nums, m):
    ans.append(sorted(i))
ans.sort()
for j in ans:
    for k in j:
        print(k, end=" ")
    print()
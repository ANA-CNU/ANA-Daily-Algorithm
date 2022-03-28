import sys
from itertools import combinations
n, m = map(int, sys.stdin.readline().split())
nums = list(map(int, sys.stdin.readline().split()))
nums.sort()
p = sorted(list(set(combinations(nums, m))))
for i in p:
    for j in sorted(i):
        print(j, end=" ")
    print()
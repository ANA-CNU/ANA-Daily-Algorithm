import sys
from itertools import permutations
n, m = map(int, sys.stdin.readline().split())
nums = list(map(int, sys.stdin.readline().split()))
nums.sort()
p = sorted(list(set(permutations(nums, m))))
for j in p:
    for k in j:
        print(k, end=" ")
    print()
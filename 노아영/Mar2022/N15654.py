from itertools import permutations
import sys
n, m = map(int, sys.stdin.readline().split())
nums = list(map(int, sys.stdin.readline().rstrip().split()))
a = []
for i in permutations(nums, m):
    a.append(i)
a.sort()
for k in a:
    for l in k:
        print(l, end=" ")
    print()
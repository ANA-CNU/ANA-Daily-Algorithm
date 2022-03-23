import sys
from itertools import combinations_with_replacement
n, m = map(int, sys.stdin.readline().split())
nums = list(map(int, sys.stdin.readline().split()))
a = []
for i in combinations_with_replacement(nums, m):
    tmp = sorted(i)
    if tmp not in a:
        a.append(tmp)
a.sort()
for j in a:
    for k in j:
        print(k,end=" ")
    print()
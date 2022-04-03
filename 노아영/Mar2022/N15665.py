import sys
from itertools import product
n, m = map(int, sys.stdin.readline().split())
nums = list(map(int, sys.stdin.readline().split()))
p = list(set(product(nums, repeat=m)))
p.sort()
for i in p:
    for j in i:
        print(j, end=" ")
    print()
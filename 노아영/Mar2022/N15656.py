import sys
from itertools import product
n, m = map(int, sys.stdin.readline().split())
nums = list(map(int, sys.stdin.readline().split()))
p = sorted(list(product(nums, repeat=m)))
for i in p:
    for j in i:
        print(j, end=" ")
    print()
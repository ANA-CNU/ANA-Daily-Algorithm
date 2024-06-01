# 크면서 작은 수 - 2992

import sys
from itertools import permutations
input = sys.stdin.readline

raw_n = input().strip()
n = int(raw_n)
arr = list(raw_n)
nums = []
for permutation in permutations(arr, len(arr)):
    tmp = int("".join(permutation))
    if tmp > n:
        nums.append(tmp)
result = sorted(nums)[0] if nums else 0
print(result)

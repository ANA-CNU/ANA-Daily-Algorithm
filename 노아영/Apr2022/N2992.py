from random import randrange
import sys
from itertools import permutations
x = sys.stdin.readline().rstrip()
numX = int(x)
nums = []
for i in permutations(list(x), len(x)):
    n = int("".join(i))
    if n not in nums:
        nums.append(n)
nums.sort()
idx = nums.index(numX)
if idx == len(nums)-1:
    print(0)
else:
    print(nums[idx+1])
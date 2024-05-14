# 차이를 최대로 - 10819

import sys
from itertools import permutations

n = int(sys.stdin.readline())
arr = list(map(int, sys.stdin.readline().split()))

max_sum = 0
for permutation in permutations(arr, n):
    cur_sum = 0
    for i in range(len(permutation)-1):
        cur_sum += abs(permutation[i] - permutation[i+1])

    max_sum = max(max_sum, cur_sum)

print(max_sum)
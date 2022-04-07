import sys
from itertools import combinations
n, s = map(int, sys.stdin.readline().split())
nums = list(map(int, sys.stdin.readline().split()))
cnt = 0
for i in range(1, n+1):
    for j in combinations(range(n), i):
        t = 0
        for k in j:
            t += nums[k]
        if t == s:
            cnt += 1
print(cnt)
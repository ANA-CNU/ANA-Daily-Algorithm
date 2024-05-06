# 부분수열의 합 - 1182

from itertools import combinations

n, s = map(int, input().split())
super_set = list(map(int, input().split()))
cnt = 0

for r in range(1, n+1):
    for sub_set in combinations(super_set, r):
        if sum(sub_set) == s:
            cnt += 1

print(cnt)

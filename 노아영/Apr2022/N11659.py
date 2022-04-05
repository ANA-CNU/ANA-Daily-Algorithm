import sys
n, m = map(int, sys.stdin.readline().split())
nums = list(map(int, sys.stdin.readline().split()))
for i in range(1, n):
    nums[i] = nums[i-1]+nums[i]
for _ in range(m):
    i, j = map(int, sys.stdin.readline().split())
    if i == 1:
        print(nums[j-1])
    else:
        print(nums[j-1]-nums[i-2])
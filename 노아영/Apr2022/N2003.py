import sys
n, m = map(int, sys.stdin.readline().split())
nums = list(map(int, sys.stdin.readline().split()))
l, r = 0, 0
s, cnt = nums[0], 0
while r < n:
    if s == m:
        cnt += 1
        r += 1
        if r >= n:
            break
        s += nums[r] - nums[l]
        l += 1
    elif s < m:
        r += 1
        if r >= n:
            break
        s += nums[r]
    elif s > m:
        s -= nums[l]
        l += 1
print(cnt)
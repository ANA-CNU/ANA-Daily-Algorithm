import sys

n = int(input())
dp = [sys.maxsize for i in range(n + 1)]
square = [i*i for i in range(1, 317)]
for i in range(1, n + 1):
    for j in square:
        if j > i:
            break
        dp[j] = 1
        dp[i] = min(dp[i], dp[i - j] + 1)
print(dp[-1])
import sys
n, k = map(int, sys.stdin.readline().split())
dp = [[0 for _ in range(n+1)] for _ in range(n+1)]

for i in range(n+1):
    for j in range(n+1):
        if j == 0:
            dp[i][j] = 1
        elif i == j:
            dp[i][j] = 1
        elif j == 1:
            dp[i][j] = i
        elif n >= k:
            dp[i][j] = dp[i-1][j-1] + dp[i-1][j]
print(*dp, sep="\n")
print(dp[n][k] % 10007)
import sys
dp = [0]*101
dp[1] = 1
dp[2] = 1
for i in range(3, 101):
    dp[i] = dp[i-2] + dp[i-3]
N = int(sys.stdin.readline())
for i in range(N):
    t = int(sys.stdin.readline())
    print(dp[t])
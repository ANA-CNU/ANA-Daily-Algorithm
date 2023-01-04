N = int(input())
dp = [[1]+[0]*9 for _ in range(N+1)]

for i in range(1, N+1):
    for j in range(1, 10):
        dp[i][j] = dp[i-1][j]+dp[i][j-1]

print (sum(dp[N])%10007)
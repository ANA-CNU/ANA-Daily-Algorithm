N = int(input())
dp = [1]*N
for i in range(2, N):
    dp[i] = dp[i-2]+dp[i-1]
print (dp[N-1])
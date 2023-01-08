N, M = map(int, input().split())
dp = [list(map(int, input().split())) for _ in range(N)]

for i in range(1, N):
    dp[i][0] = dp[i][0]+dp[i-1][0]
for i in range(1, M):
    dp[0][i] = dp[0][i]+dp[0][i-1]

for i in range(1, N):
    for j in range(1, M):
        dp[i][j] = dp[i][j]+max(dp[i-1][j], dp[i][j-1])

print (dp[N-1][M-1])

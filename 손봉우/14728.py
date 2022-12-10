N, T = map(int, input().split())

item = [tuple(map(int, input().split())) for _ in range(N)]
dp = [[0]*(T+1) for _ in range(N+1)]

for i in range(1, N+1):
    for j in range(1, T+1):
        curT,curS = item[i-1]
        if curT <= j:
            dp[i][j] = max(dp[i-1][j], curS+dp[i-1][j-curT])
        else:
            dp[i][j] = dp[i-1][j]

print (dp[N][T])
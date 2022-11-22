N, K = map(int, input().split())

B = []
dp = [[0]*(K+1) for _ in range(N+1)]
for i in range(N):
    B.append(tuple(map(int, input().split())))

for i in range(1, N+1):
    for j in range(1, K+1):
        curW, curV = B[i-1]
        if curW <= j:
            dp[i][j] = max(dp[i-1][j], curV + dp[i-1][j-curW])
        else:
            dp[i][j] = dp[i-1][j]

print (dp[N][K])
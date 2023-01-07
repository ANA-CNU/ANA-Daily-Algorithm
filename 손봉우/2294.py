N, K = map(int, input().split())
V = []
for _ in range(N):
    V.append(int(input()))
dp = [[0]+([10001]*K) for _ in range(N+1)]

for i in range(1, N+1):
    for j in range(1, K+1):
        if j >= V[i-1]:
            dp[i][j] = min(dp[i-1][j], dp[i][j-V[i-1]]+1)
        else:
            dp[i][j] = dp[i-1][j]

res = dp[N][K]

print (res if res != 10001 else -1)
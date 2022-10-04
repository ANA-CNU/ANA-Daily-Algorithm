N = int(input())
dp = [list(map(int, input().split())) for _ in range(N)]

for i in range(N-2, -1, -1):
    for j in range(i+1):
        dp[i][j] += max(dp[i+1][j], dp[i+1][j+1])

print (dp[0][0])
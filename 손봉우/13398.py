N = int(input())
L = list(map(int, input().split()))
res = 0
dp = [[-1000]*N for _ in range(2)]
dp[0][0] = L[0]
for i in range(1, N):
    dp[0][i] = max(dp[0][i-1]+L[i], L[i])
    dp[1][i] = max(dp[1][i-1]+L[i], dp[0][i-1])

print (max(max(dp[0]), max(dp[1])))
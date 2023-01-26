N = int(input())
P = list(map(int, input().split()))
dp = [10000000]*(N)

for i in range(N):
    for j in range(i):
        dp[i] = min(dp[i], dp[j]+P[i-j-1])
    dp[i] = min(dp[i], P[i])

print (dp[N-1])
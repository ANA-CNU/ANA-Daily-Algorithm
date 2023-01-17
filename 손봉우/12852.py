N = int(input())

dp = [0, 0] + [10**6]*(N-1)
bt = [0]*(N+1)

for i in range(2, N+1):
    dp[i] = min(dp[i-1]+1, dp[i])
    bt[i] = i-1

    if i%3 == 0:
        if dp[i//3]+1 < dp[i]:
            dp[i] = dp[i//3]+1
            bt[i] = i//3
    if i%2 == 0:
        if dp[i//2]+1 < dp[i]:
            dp[i] = dp[i//2]+1
            bt[i] = i//2
        dp[i] = min(dp[i], dp[i//2]+1)

print(dp[N])
i = N
while i != 1:
    print (i, end=' ')
    i = bt[i]
print (1)

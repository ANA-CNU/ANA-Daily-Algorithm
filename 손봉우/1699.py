N = int(input())

dp = [100000]*(N+1)
tmp = 1

for i in range(1, N+1):
    if i**(1/2) % 1 == 0:
        dp[i] = 1
        tmp += 1
    else:
        for j in range(1, tmp):
            dp[i] = min(dp[i], dp[i-(j**2)]+1)

print (dp[N])
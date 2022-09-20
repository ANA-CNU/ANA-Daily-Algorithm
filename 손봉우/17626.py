import math

N = int(input())
dp = [0]*(N+1)
dp[1] = 1

for i in range(2, N+1):
    j = 1
    min_t = 1e9
    while (j**2) <= i:
        min_t = min(min_t, dp[i - j**2])
        j+=1
    dp[i] = min_t+1
print (dp[N])
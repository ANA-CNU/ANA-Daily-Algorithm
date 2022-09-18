N = int(input())

dp = [1, 1]+[0] * 999

for i in range(2, N+1):
    dp[i] = (dp[i-1]+(dp[i-2]*2)) % 10007

print (dp[N])


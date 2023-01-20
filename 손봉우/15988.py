T = int(input())
L = []
[L.append(int(input())) for _ in range(T)]
N = max(L)
dp = [1, 2, 4]+[0]*(N-3)

for i in range(3, N):
    dp[i] = (dp[i-1]+dp[i-2]+dp[i-3])%1000000009

[print(dp[i-1]) for i in L]
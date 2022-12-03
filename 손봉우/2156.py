N = int(input())
L = [int(input()) for _ in range(N)]
dp = [0]*(N)

dp[0] = L[0]
if N > 1:
    dp[1] = L[0]+L[1]
if N > 2:
    dp[2] = max(L[0]+L[2], L[1]+L[2], dp[1])
for i in range(3, N):
    dp[i] = max(dp[i-3]+L[i-1]+L[i], dp[i-2]+L[i], dp[i-1])

print (dp[N-1])
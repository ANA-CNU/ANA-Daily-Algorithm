N, M = map(int, input().split())

L = [list(map(int, input())) for _ in range(N)]

dp = [[0]*(M+1) for _ in range(N+1)]

result = 0

for i in range(1, N+1):
    for j in range(1, M+1):
        dp[i][j] = L[i-1][j-1]
        
        if L[i-1][j-1]:
            dp[i][j] = min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1])+1
        result = max(result, dp[i][j])

for i in dp:
    print (i)
print (result**2)
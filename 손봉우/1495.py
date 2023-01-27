N, S, M = map(int, input().split())
P = list(map(int, input().split()))
dp = [[False]*(M+1) for _ in range(N+1)]

dp[0][S] = True

for i in range(1, N+1):
    for j in range(M+1):
        if dp[i-1][j]:
            if 0 <= j-P[i-1] <= M:
                dp[i][j-P[i-1]] = True
            if 0 <= j+P[i-1] <= M:
                dp[i][j+P[i-1]] = True
result = -1
for i in range(M+1):
    if dp[N][i]:
        result = i
print (result)
N = int(input())

L = [list(map(int, input().split())) for _ in range(N)]
dp = [[0]*N for _ in range(N)]
dp[0][0] = 1
for i in range(N):
    for j in range(N):
        if L[i][j] == 0:
            continue
        if dp[i][j] != 0:
            right = j+L[i][j]
            bottom = i+L[i][j]

            if right < N:
                dp[i][right] += dp[i][j]
            if bottom < N:
                dp[bottom][j] += dp[i][j]
print (dp[N-1][N-1])

N = int(input())
L = list(map(int, input().split()))
dp = [[0]*21 for _ in range(N-1)]

dp[0][L[0]] = 1

for i in range(0, N-2):
    for j in range(21):
        if dp[i][j] != 0:
            k = L[i+1]
            if k != 0:
                if 0 <= j+k <= 20:
                    dp[i+1][j+k] += dp[i][j]
                if 0 <= j-k <= 20:
                    dp[i+1][j-k] += dp[i][j]
            else:
                dp[i+1][j] = dp[i][j]*2
print (dp[N-2][L[-1]])
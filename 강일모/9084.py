#9084
import sys
input = sys.stdin.readline

T = int(input())

for _ in range(T):
    N = int(input())
    coins = list(map(int, input().split()))
    M = int(input())

    dp = [ [0 for _ in range(10001)] for _ in range(N+1) ]
    for i in range(N+1):
        dp[i][0] = 1

    for i in range(1, N+1):
        for j in range(1, 10001):
            if j < coins[i-1]:
                dp[i][j] = dp[i-1][j]
            else:
                dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]]

    print(dp[N][M])
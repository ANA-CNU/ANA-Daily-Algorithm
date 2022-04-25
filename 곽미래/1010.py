import sys


def f(n, m):
    dp = [[0 for _ in range(m+1)] for _ in range(m+1)]
    for i in range(m+1):
        for j in range(m+1):
            if j == 0:
                dp[i][j] = 1
            elif j == i:
                dp[i][j] =1
            elif j == 1:
                dp[i][j] = i
            elif m >= n:
                dp[i][j] = dp[i-1][j-1] + dp[i-1][j]
    return dp[m][n]


t = int(sys.stdin.readline())
for i in range(t):
    n, m = map(int, sys.stdin.readline().split())
    print(f(n, m))
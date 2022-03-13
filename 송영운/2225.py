input = __import__('sys').stdin.readline
if __name__ == "__main__":
    n, k = map(int, input().split())
    dp = [[0]*(n+1) for _ in range(k+1)]

    for j in range(n+1):
        dp[1][j] = 1
    for i in range(1, k+1):
        for j in range(n+1):
            for z in range(j+1):
                dp[i][j] += dp[i-1][j - z]
    print(dp[k][n] % 1000000000)
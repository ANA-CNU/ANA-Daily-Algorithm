input = __import__('sys').stdin.readline
if __name__ == "__main__":
    n = int(input())
    p = list(map(int, input().split()))
    p.insert(0, 0)
    m = int(input())

    dp = [['']*(m+1) for _ in range(n+1)]
    for i in range(1, n+1):
        for j in range(1, m+1):
            if j >= p[i]:
                if dp[i-1][j] == '':
                    dp[i][j] = str(i-1) + dp[i][j-p[i]]
                else:
                    dp[i][j] = str(max(int(dp[i-1][j]), int(str(i-1) + dp[i][j-p[i]]),int(str(i-1) + dp[1][j-p[i]])))
            else:
                dp[i][j] = dp[i-1][j]
    print(int(dp[n][m]))

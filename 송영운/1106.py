input = __import__('sys').stdin.readline
if __name__ == "__main__":
    c, n = map(int, input().split())
    ad = [0]
    dp = [[0]*(c) for _ in range(n+1)]
    for i in range(n):
        price, man = map(int, input().split())
        ad.append((price, man))
    for i in range(1, n+1):
        for j in range(c):
            price, man = ad[i]
            if dp[i-1][j] == 0:
                dp[i][j] = ((j//man) + 1) * price
            else:
                if j+1 <= man:
                    dp[i][j] = min(dp[i-1][j], price)
                else:
                    dp[i][j] = min(dp[i-1][j], price + dp[i][j - man])
    print(dp[n][c-1])
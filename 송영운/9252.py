input = __import__('sys').stdin.readline
if __name__ == "__main__":
    a = input().strip()
    b = input().strip()
    a = ' '+a
    b = ' '+b
    len_a, len_b = len(a), len(b)
    dp = [['']*(len_a) for _ in range(len_b)]
    max_len = 0
    max_str = ''
    for i in range(1, len_b):
        for j in range(1, len_a):
            if b[i] == a[j]:
                if len(dp[i-1][j-1])+1 > len(dp[i-1][j]) and len(dp[i-1][j-1])+1 > len(dp[i][j-1]):
                    dp[i][j] = dp[i-1][j-1] + a[j]
                else:
                    if len(dp[i - 1][j]) > len(dp[i][j - 1]):
                        dp[i][j] = dp[i - 1][j]
                    else:
                        dp[i][j] = dp[i][j - 1]
            else:
                if len(dp[i-1][j]) > len(dp[i][j-1]):
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = dp[i][j-1]
            if max_len < len(dp[i][j]):
                max_len = len(dp[i][j])
                max_str = dp[i][j]
    print(max_len)
    print(max_str)
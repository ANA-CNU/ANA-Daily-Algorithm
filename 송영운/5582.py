input = __import__('sys').stdin.readline
if __name__ == "__main__":
    str2 = input().strip()
    str1 = input().strip()
    dp = [[0]*(len(str2) + 1) for _ in range(len(str1) + 1)]
    for i in range(1, len(str1) + 1):
        for j in range(1, len(str2) + 1):
            if str1[i - 1] == str2[j - 1]:
                dp[i][j] = dp[i-1][j-1] + 1
    print(max([max(dp[i]) for i in range(len(str1) + 1)]))
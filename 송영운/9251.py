input = __import__('sys').stdin.readline
if __name__ == "__main__":
    str1 = list(input().strip())
    str2 = list(input().strip())
    str1.insert(0, '')
    str2.insert(0, '')
    dp = [[0]*(len(str2)) for _ in range(len(str1))]
    for i in range(1, len(str1)):
        for j in range(1, len(str2)):
            if str1[i] == str2[j]:
                dp[i][j] = dp[i-1][j-1] + 1
            else:
                dp[i][j] = max(dp[i][j-1], dp[i-1][j])
    print(dp[len(str1)-1][len(str2)-1])
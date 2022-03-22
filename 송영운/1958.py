input = __import__('sys').stdin.readline
if __name__ == "__main__":
    str1 = input().strip()
    str2 = input().strip()
    str3 = input().strip()
    str1 = " "+str1
    str2 = " "+str2
    str3 = " "+str3
    dp = [[[0]*(len(str1)) for _ in range(len(str2))] for _ in range(len(str3))]
    max_length = 0
    for y in range(1, len(str2)):
        for z in range(1, len(str1)):
            for x in range(1, len(str3)):
                if str1[z] == str2[y] and str2[y] == str3[x]:
                    dp[x][y][z] = dp[x-1][y-1][z-1] + 1
                else:
                    dp[x][y][z] = max(dp[x][y][z - 1], dp[x][y - 1][z], dp[x - 1][y][z])
                max_length = max(max_length, dp[x][y][z])
    print(max_length)

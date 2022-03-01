import sys
input = __import__('sys').stdin.readline
MAX_N = 101
if __name__ == "__main__":
    min_dp = [-1, -1, 1, 7, 4, 2, 6, 8, 10, 18]
    max_dp = [-1, -1, 1, 7, 11, 71, 111, 711, 1111, 7111]
    count = [6, 2, 5, 5, 4, 5, 6, 3, 7, 6]
    while len(min_dp) < MAX_N:
        l = len(min_dp)
        min_num = sys.maxsize
        max_num = -1
        for i in range(0, 10):
            min_num = min(min_num, int(str(min_dp[l - count[i]]) + str(i)))
            max_num = max(max_num, int(str(max_dp[l - count[i]]) + str(i)))
        min_dp.append(min_num)
        max_dp.append(max_num)
    t = int(input())
    for i in range(t):
        n = int(input())
        print(min_dp[n], max_dp[n])
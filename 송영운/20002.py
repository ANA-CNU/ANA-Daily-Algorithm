import copy

input = __import__('sys').stdin.readline
if __name__ == "__main__":
    n = int(input())
    board = [list(map(int, input().split())) for _ in range(n)]
    dp = copy.deepcopy(board)
    ac_sum = copy.deepcopy(board)
    for i in range(1, n):
        ac_sum[0][i] += ac_sum[0][i-1]
        ac_sum[i][0] += ac_sum[i-1][0]
    for i in range(1, n):
        for j in range(1, n):
            ac_sum[i][j] += ac_sum[i-1][j] + ac_sum[i][j-1] - ac_sum[i-1][j-1]

    for i in range(n):
        for j in range(n):
            if i >= j:
                for z in range(1, j+2):
                    tmp = ac_sum[i][j]
                    if i-z >= 0:
                        tmp -= ac_sum[i-z][j]
                    if j-z >= 0:
                        tmp -= ac_sum[i][j-z]
                    if i-z>=0 and j-z>=0:
                        tmp += ac_sum[i-z][j-z]
                    dp[i][j] = max(dp[i][j], tmp)
            else:
                for z in range(1,i+2):
                    tmp = ac_sum[i][j]
                    if i-z >= 0:
                        tmp -= ac_sum[i-z][j]
                    if j-z >= 0:
                        tmp -= ac_sum[i][j-z]
                    if i-z>=0 and j-z>=0:
                        tmp += ac_sum[i-z][j-z]
                    dp[i][j] = max(dp[i][j], tmp)
    answer = max(map(max, dp))
    print(answer)
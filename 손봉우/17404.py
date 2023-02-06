N = int(input())
L = [list(map(int, input().split())) for _ in range(N)]

result = 100000

for i in range(3):
    dp = [[0, 0, 0] for _ in range(N)]
    dp[0] = [10000]*3
    dp[0][i] = L[0][i]
    for j in range(1, N):
        dp[j][0] = min(dp[j-1][1], dp[j-1][2])+L[j][0]
        dp[j][1] = min(dp[j-1][0], dp[j-1][2])+L[j][1]
        dp[j][2] = min(dp[j-1][0], dp[j-1][1])+L[j][2]

    dp[N-1][i] = 100000
    result = min([result]+dp[N-1])

print (result)
N, M, K = map(int, input().split())
K -= 1
ox = K % M
oy = K // M
def solve(sx, sy, ex, ey):
    dp = [[0]*M for _ in range(N)]
    dp[sy][sx] = 1
    for i in range(sy, ey+1):
        for j in range(sx, ex+1):
            if i-1 >= 0:
                dp[i][j] += dp[i-1][j]
            if j-1 >= 0:
                dp[i][j] += dp[i][j-1]
    return dp[ey][ex]

if K != -1:
    print (solve(0, 0, ox, oy) * solve(ox, oy, M-1, N-1))
else:
    print (solve(0, 0, M-1, N-1))
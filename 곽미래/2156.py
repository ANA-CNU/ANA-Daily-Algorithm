import sys
n = int(sys.stdin.readline())
grapeJuice = [int(sys.stdin.readline()) for _ in range(n)]
if len(grapeJuice) < 3:
    grapeJuice = grapeJuice + [0,0]
dp = [0]*(n+2)
dp[0] = grapeJuice[0]
dp[1] = grapeJuice[0] + grapeJuice[1]
dp[2] = max(dp[1], grapeJuice[0]+grapeJuice[2], grapeJuice[1]+grapeJuice[2])
for i in range(3, n):
    dp[i] = max(dp[i-1], grapeJuice[i]+grapeJuice[i-1]+dp[i-3], grapeJuice[i]+dp[i-2])
print(dp[n-1])
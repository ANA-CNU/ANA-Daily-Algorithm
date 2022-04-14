import sys
n = int(sys.stdin.readline())
line = [tuple(map(int, sys.stdin.readline().split())) for _ in range(n)]
dp = [0]*n
line.sort()
print(line)
for i in range(n):
    for j in range(i):
        a1, b1 = line[i]
        a2, b2 = line[j]
        if a1 > a2 and b1 > b2 and dp[i] < dp[j]:
            dp[i] = dp[j]
    dp[i] += 1
print(dp)
print(n - max(dp))

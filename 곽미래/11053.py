import sys
n = int(sys.stdin.readline())
numbers = list(map(int, sys.stdin.readline().split()))
dp = [0]*n
for i in range(n):
    for j in range(i):
        if numbers[j] < numbers[i] and dp[i] < dp[j]:
            dp[i] = dp[j]
    dp[i] += 1
print(max(dp))
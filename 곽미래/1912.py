import sys
n = int(sys.stdin.readline())
numbers = list(map(int, sys.stdin.readline().split()))
dp = [i for i in numbers]
for i in range(1, n):
    dp[i] = max(dp[i], dp[i-1] + numbers[i])
print(max(dp))
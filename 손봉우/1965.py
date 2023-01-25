N = int(input())
L = list(map(int, input().split()))
dp = [0]*N

for i in range(1, N):
    for j in range(i):
        if L[j]<L[i] and dp[i]<dp[j]+1:
            dp[i] = dp[j]+1
print(max(dp)+1)
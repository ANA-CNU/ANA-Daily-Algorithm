N = int(input())
L = list(map(int, input().split()))

dp = [1]*(N)

for i in range(N):
    for j in range(i):
        if L[j]<L[i]:
            dp[i] = max(dp[i], dp[j]+1)

print (dp)
print (max(dp))
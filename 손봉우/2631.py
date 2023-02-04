N = int(input())
L = []
for i in range(N):
    L.append(int(input()))

dp = [1]*N

for i in range(N):
    for j in range(i):
        if L[j] < L[i]:
            dp[i] = max(dp[i], dp[j]+1)

print (N-max(dp))
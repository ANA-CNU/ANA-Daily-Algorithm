N = int(input())
L = [list(map(int, input().split())) for _ in range(N)]
L = [i[1] for i in sorted(L)]
dp = [0]*N
for i in range(N):
    dp[i] = 1
    for j in range(i):
        if L[j] < L[i]:
            dp[i] = max(dp[i], dp[j]+1)

print (N-max(dp))

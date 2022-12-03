N = int(input())
L = list(map(int, input().split()))

dp = [1]*N

for i in range(1, N):
    cnt = 0
    for j in range(i):
        if L[i]>L[j]:
            dp[i] = max(dp[i], dp[j]+1)
result = []
T = max(dp)

print (T)

for i in range(N-1, -1, -1):
    if dp[i] == T:
        result.append(L[i])
        T -= 1
result.reverse()

print(*result)

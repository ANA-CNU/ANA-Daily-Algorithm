S1 = list(input())
S2 = list(input())
L1 = len(S1)+1
L2 = len(S2)+1

dp = [[0]*L1 for _ in range(L2)]
result = 0

for i in range(1, L2):
    for j in range(1, L1):
        if S1[j-1] == S2[i-1]:
            dp[i][j] = dp[i-1][j-1]+1
            result = max(result, dp[i][j])

print (result)
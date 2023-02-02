S1 = list(input())
S2 = list(input())

N1 = len(S1)+1
N2 = len(S2)+1

dp = [[0]*(N1) for _ in range(N2)]

for i in range(1, N2):
    for j in range(1, N1):
        if S2[i-1] == S1[j-1]:
            dp[i][j] = dp[i-1][j-1] + 1
        else:
            dp[i][j] = max(dp[i-1][j], dp[i][j-1])
i = N2-1
j = N1-1
print (dp[i][j])
if dp[i][j] == 0:
    exit()

result = ''
while True:
    if i==0 or j==0:
        break
    
    if dp[i][j] == dp[i-1][j]:
        i -= 1
    elif dp[i][j] == dp[i][j-1]:
        j -= 1
    else:
        result = S1[j-1] + result
        i -= 1
        j -= 1

print (result)
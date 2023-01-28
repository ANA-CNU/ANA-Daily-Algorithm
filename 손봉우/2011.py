L = list(input())
N = len(L)
MOD = 10**6

def solution():
    if L[0] == '0':
        return 0

    dp = [1, 1]+[0]*(N-1)
    
    for i in range(2, N+1):
        if L[i-1] != '0':
            dp[i] = (dp[i]+dp[i-1]) % MOD
        if 10 <= int(L[i-2]+L[i-1]) <= 26:
            dp[i] = (dp[i]+dp[i-2]) % MOD
    return dp[N]


print (solution())
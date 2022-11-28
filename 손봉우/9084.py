for _ in range(int(input())):
    N = int(input())
    L = map(int, input().split())
    M = int(input())

    dp = [0] * (M+1)
    dp[0] = 1

    for i in L:
        for j in range(1, M+1):
            if j-i >= 0:
                dp[j] += dp[j-i]
    print (dp[M])
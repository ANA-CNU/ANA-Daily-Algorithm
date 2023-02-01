import sys
input = sys.stdin.readline

N = int(input())
L = list(map(int, input().split()))

dp = [[0]*N for _ in range(N)]

for i in range(N):
    dp[i][i] = 1
    if i < N-1 and L[i] == L[i+1]:
        dp[i][i+1] = 1

for i in range(N, -1, -1):
    for j in range(i+1, N):
        if dp[i+1][j-1] and L[i] == L[j]:
            dp[i][j] = 1

for i in range(int(input())):
    S, E = map(int, input().split())
    print (dp[S-1][E-1])

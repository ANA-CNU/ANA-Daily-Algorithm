T = int(input())

for _ in range(T):
    N = int(input())
    L = [[0]+list(map(int, input().split())) for _ in range(2)]

    for i in range(2, N+1):
        L[0][i] += max(L[1][i-2], L[1][i-1])
        L[1][i] += max(L[0][i-2], L[0][i-1])
    print (max(L[0][N], L[1][N]))
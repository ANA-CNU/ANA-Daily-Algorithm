N = int(input())
L = [list(map(int, input().split())) for _ in range(N)]
dp1 = [L[0][i] for i in range(3)]
dp2 = [L[0][i] for i in range(3)]

for i in range(1, N):
    tmp1 = [0]*3
    tmp2 = [0]*3
    for j in range(3):

        if j == 0:
            tmp1[0] = L[i][j] + max(dp1[0], dp1[1])
            tmp2[0] = L[i][j] + min(dp2[0], dp2[1])
        elif j == 1:
            tmp1[1] = L[i][j] + max(dp1[0], dp1[1], dp1[2])
            tmp2[1] = L[i][j] + min(dp2[0], dp2[1], dp2[2])
        else:
            tmp1[2] = L[i][j] + max(dp1[1], dp1[2])
            tmp2[2] = L[i][j] + min(dp2[1], dp2[2])
    dp1 = [i for i in tmp1]
    dp2 = [i for i in tmp2]

print (max(dp1), min(dp2))
            
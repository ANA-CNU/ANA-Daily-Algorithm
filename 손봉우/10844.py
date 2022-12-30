N = int(input())
L = [[0]*12 for _ in range(100)]
L[0] = [0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0]

for i in range(1, N):
    for j in range(1, 11):
        L[i][j] = L[i-1][j-1]+L[i-1][j+1]

print (sum(L[N-1])%1000000000)
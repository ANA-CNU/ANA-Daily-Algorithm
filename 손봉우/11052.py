N = int(input())
P = list(map(int, input().split()))

D = [P[0]]+[0]*(N-1)

for i in range(1, N):
    for j in range(1, i+1):
        D[i] = max(D[i-j]+P[j-1], D[i])
    D[i] = max(P[i], D[i])

print (D[N-1])
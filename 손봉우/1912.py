N = int(input())
L = list(map(int, input().split()))

for i in range(1, N):
    L[i] = max(L[i-1]+L[i], L[i])

print (max(L))
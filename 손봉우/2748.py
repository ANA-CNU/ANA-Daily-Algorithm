N = int(input())

L = [0, 1] + [0]*89

for i in range(2, N+1):
    L[i] = L[i-1]+L[i-2]

print (L[N])
T = int(input())
L = [0, 1]+[0]*39

for i in range(2, 41):
    L[i] = L[i-1]+L[i-2]

for i in range(T):
    N = int(input())
    if N==0:
        print (1, 0)
    else:
        print (L[N-1], L[N])
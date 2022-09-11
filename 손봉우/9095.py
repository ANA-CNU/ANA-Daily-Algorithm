T = int(input())

L = [0, 0, 1] + [0]*10

for i in range(3, 13):
    L[i] = L[i-1]+L[i-2]+L[i-3]

for _ in range(T):
    print (L[int(input())+2])

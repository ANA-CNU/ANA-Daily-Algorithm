D, K = map(int, input().split())
L = [(1, 0), (0, 1)]

for i in range(2, D):
    L.append((L[i-2][0]+L[i-1][0], L[i-2][1]+L[i-1][1]))

A = 1
B = 2

while True:
    if A*L[D-1][0] + B*L[D-1][1] == K:
        break

    if A+1 == B:
        B += 1
        A = 1
    else:
        A += 1

print (A,'\n',B, sep='')
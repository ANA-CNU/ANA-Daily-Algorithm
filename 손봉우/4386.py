import math

V = int(input())

N = int((V*(V+1))/2)
L = []
for i in range(V):
    L.append(tuple(map(float, input().split())))
E = []
P = [i for i in range(N)]

for i in range(V):
    x1, y1 = L[i]
    for j in range(i, V):
        x2, y2 = L[j]
        c = math.sqrt(pow(x1-x2, 2)+pow(y1-y2, 2))
        E.append ((c, i+1, j+1))

def find(x):
    if x != P[x]:
        P[x] = find(P[x])
    return P[x]

def union(a, b):
    if a > b:
        P[a] = b
    else:
        P[b] = a

result = 0
E.sort()

for i in E:
    c, a, b = i
    a = find(a)
    b = find(b)
    if a != b:
        union(a, b)
        result += c

print (round(result*100)/100)
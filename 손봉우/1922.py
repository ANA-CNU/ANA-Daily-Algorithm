N = int(input())
M = int(input())

L = []
for i in range(M):
    a, b, c = map(int, input().split())
    L.append((c, a-1, b-1))
P = [i for i in range(N)]

def find(x):
    if P[x] != x:
        P[x] = find(P[x])
    return P[x]

def union(a, b):
    if a > b:
        P[a] = b
    else:
        P[b] = a

result = 0
L.sort()

for i in L:
    c, a, b = i
    a = find(a)
    b = find(b)
    if a != b:
        union (a, b)
        result += c
print (result)
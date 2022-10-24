V, E = map(int, input().split())

L = []
for i in range(E):
    a, b, c = map(int, input().split())
    L.append([a-1, b-1, c])
P = [i for i in range(V)]

L.sort(key=lambda x : x[2])
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
temp = []

for (a, b, c) in L:
    a = find(a)
    b = find(b)
    if a != b:
        union(a, b)
        result += c
        temp.append(c)

result -= temp.pop()
print (result)
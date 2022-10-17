V, E = map(int, input().split())
L = []
for _ in range(E):
    a, b, cost = map(int, input().split())
    L.append((cost, a-1, b-1))

P = [i for i in range(V)]
def find(x):
    if P[x] != x:
        P[x] = find(P[x])
    return P[x]

def union(a, b):
    a = find(a)
    b = find(b)
    if a < b:
        P[b] = a
    else:
        P[a] = b

result = 0 
L.sort()

for i in L:
    cost, a, b = i
    if find(a) != find(b):
        union(a, b)
        result += cost

print (result)
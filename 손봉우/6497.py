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

while True:
    M, N = map(int, input().split())
    if (M, N) == (0, 0):
        break

    E = []
    for _ in range(N):
        a, b, c = map(int, input().split())
        E.append((c, a, b))
    P = [i for i in range(M)]

    result = 0
    E.sort()
    for i in E:
        c, a, b = i
        if find(a) != find(b):
            union(a, b)
        else:
            result += c

    print (result)
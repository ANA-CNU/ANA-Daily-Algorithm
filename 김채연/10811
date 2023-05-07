N, M = map(int, input().split())
lst = list(range(1, N+1))
    
for _ in range(M):
    a, b = map(int, input().split())
    cop = []
    for j in range(b-a+1):
        for k in range(a-1, b):
            cop.append(lst[k])
    cop.reverse()
    for l in range(a-1, b):
        lst[l] = cop[l - (a-1)]

print(*lst)

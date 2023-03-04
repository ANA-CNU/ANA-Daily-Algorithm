N, M = map(int, input().split())
T = list(map(int, input().split()))
T = set(T[1:])

member = [set() for _ in range(N)]
party = []
visit = [False]*M

def explore(n):
    for i in member[n]:
        if not visit[i]:
            visit[i] = True
            for j in party[i]:
                explore(j-1)
    
for i in range(M):
    lst = list(map(int, input().split()))
    lst = lst[1:]
    for j in lst:
        member[j-1].add(i)
    party.append(set(lst))

for i in T:
    explore(i-1)

cnt = 0
for i in visit:
    if not i:
        cnt += 1

print (cnt)
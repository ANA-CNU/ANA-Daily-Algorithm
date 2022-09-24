N, M = map(int, input().split())
L = list(map(int, input().split()))
L.sort()
res = []
visit = [False]*N

def dfs():
    if len(res) == M:
        for i in res:
            print (i, end=' ')
        print()
        return
    
    for i in range(N):
        if not visit[i]:
            visit[i]=True
            res.append(L[i])
            dfs()
            res.pop()
            visit[i]=False
dfs()
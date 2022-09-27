N, M = map(int, input().split())
L = list(map(int, input().split()))
L.sort()

visit = [False]*(N)

def dfs(tmp, prev, depth):
    if depth == M:
        for i in tmp:
            print(i, end=' ')
        print()
        return
    
    for i in range(N):
        if prev<=L[i]:
            dfs(tmp+[L[i]], L[i], depth+1)

dfs([], -1, 0)
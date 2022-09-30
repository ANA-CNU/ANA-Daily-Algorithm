N, M = map(int, input().split())
L = list(map(int, input().split()))
L.sort()
visit = [False]*N
prev = 0

def dfs(tmp, d):
    if d == M:
        print (' '.join(map(str, tmp)))
        return

    prev = 0
    for i in range(N):
        if not visit[i] and prev != L[i]:
            visit[i] = True
            prev = L[i]
            dfs(tmp+[L[i]], d+1)
            visit[i] = False

dfs([], 0)
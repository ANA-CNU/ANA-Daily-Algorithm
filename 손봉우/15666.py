N, M = map(int, input().split())
L = list(set(map(int, input().split())))
N = len(L)
L.sort()

def dfs(tmp, d, a):
    if d == M:
        print (' '.join(map(str, tmp)))
        return

    prev = 0
    for i in range(N):
        if prev != L[i] and a <= L[i]:
            prev = L[i]
            dfs(tmp+[L[i]], d+1, L[i])

dfs([], 0, 0)
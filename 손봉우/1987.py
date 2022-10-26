R, C = map(int, input().split())
L = [list(input()) for _ in range(R)]

visit = set()
vx = [0, 0, -1, 1]
vy = [-1, 1, 0, 0]
result = 0

def dfs(x, y, d):
    global result

    visit.add(L[y][x])
    result = max(result, d)

    for i in range(4):
        a = x+vx[i]
        b = y+vy[i]
        if 0 <= a < C and 0 <= b < R and L[b][a] not in visit:
            dfs(a, b, d+1)
            visit.remove(L[b][a])


dfs(0, 0, 1)
print (result)
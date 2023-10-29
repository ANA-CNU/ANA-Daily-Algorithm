import sys
input = sys.stdin.readline

def dfs(x,y, S, cnt):
    global ans
    dx = [0, 0, -1, 1]
    dy = [1, -1, 0, 0]
    ans = max(ans, cnt)
    cur = a[x][y]
    S[ord(cur)-65] = True
    for i in range(4):
        X, Y = x + dx[i],y + dy[i]
        if X <0 or Y< 0 or X >= r or Y >= c:
            continue
        cur2 = a[X][Y]
        if not S[ord(cur2)-65]:
            dfs(X,Y,S,cnt +1)
            S[ord(cur2)-65] = False


r, c = map(int, input().split())
a = [list(input()) for _ in range(r)]
S = [False for _ in range(26)]
ans = 1
dfs(0, 0, S, 1)
print(ans)

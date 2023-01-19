N = int(input())

L = [list(map(int, input().split())) for _ in range(N)]
result = 0

def dfs(x, y, direc):
    global result
    if x == N-1 and y == N-1:
        result += 1
        return

    if x+1 < N and y+1 < N and L[y+1][x] == 0 and L[y][x+1] == 0 and L[y+1][x+1] == 0:
        dfs(x+1, y+1, 2)

    if (direc == 0 or direc == 2) and x+1 < N and L[y][x+1] == 0:
        dfs(x+1, y, 0)

    if (direc == 1 or direc == 2) and y+1 < N and L[y+1][x] == 0:
        dfs(x, y+1, 1)

dfs(1, 0, 0)
print(result)
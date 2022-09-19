import sys
graph = []
blank = []

for i in range(9):
    graph.append(list(map(int, sys.stdin.readline().split())))
for i in range(9):
    for j in range(9):
        if graph[i][j] == 0:
            blank.append((i, j))

def checkRow(x, a):
    for i in range(9):
        if a == graph[x][i]:
            return False
    return True

def checkCol(y, a):
    for i in range(9):
        if a == graph[i][y]:
            return False
    return True

def checkRect(x, y, a):
    nx, ny = x // 3 * 3, y // 3 * 3
    for i in range(3):
        for j in range(3):
            if a == graph[nx + i][ny + j]:
                return False
    return True

def dfs(idx):
    if idx == len(blank):
        for i in range(9):
            print(*graph[i])
        exit(0)

    for i in range(1, 10):
        x = blank[idx][0]
        y = blank[idx][1]

        if checkCol and checkRect and checkRow:
            graph[x][y] = i
            dfs(idx + 1)
            # 안되면 다른 숫자 실행
            graph[x][y] = 0

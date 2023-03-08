R, C, T = map(int, input().split())
L = [list(map(int, input().split())) for _ in range(R)]

dx = [0, 1, 0, -1]
dy = [-1, 0, 1, 0]
dx2 = [0, 1, 0, -1]
dy2 = [1, 0, -1, 0]

pur_a = (0, 0)
pur_b = (0, 0)

for i in range(R):
    if L[i][0] == -1:
        pur_a = (i, 0)
        pur_b = (i+1, 0)
        break

def diffuse(L):
    L_ = [[0]*C for _ in range(R)]

    for i in range(R):
        for j in range(C):
            if L[i][j] > 0:
                cnt = 0
                for k in range(4):
                    px = j+dx[k]
                    py = i+dy[k]

                    if 0 <= px < C and 0 <= py < R and L[py][px] != -1:
                        L_[py][px] += L[i][j] // 5
                        cnt += 1
                L_[i][j] += L[i][j] - ((L[i][j] // 5)*cnt)
    
    return L_

def air_purify(L):
    x = pur_a[1]
    y = pur_a[0]
    lastX = 0
    lastY = 0
    i = 0
    while i < 4:
        lastX = x
        lastY = y
        x += dx[i]
        y += dy[i]

        if not (0 <= x < C and 0 <= y < R) or (x, y) == (C-1, pur_a[0]+1):
            x -= dx[i]
            y -= dy[i]
            lastX = x
            lastY = y
            i += 1
            continue
        if (x, y) == (pur_a[1], pur_a[0]):
            L[pur_a[0]][pur_a[1]+1] = 0
            L[pur_a[0]][pur_a[1]] = -1
            break
        L[lastY][lastX] = L[y][x]
    
    x = pur_b[1]
    y = pur_b[0]
    i = 0
    while i < 4:
        lastX = x
        lastY = y
        x += dx2[i]
        y += dy2[i]

        if not (0 <= x < C and 0 <= y < R) or (x, y) == (C-1, pur_b[0]-1):
            x -= dx2[i]
            y -= dy2[i]
            lastX = x
            lastY = y
            i += 1
            continue
        if (x, y) == (pur_b[1], pur_b[0]):
            L[pur_b[0]][pur_b[1]+1] = 0
            L[pur_b[0]][pur_b[1]] = -1
            break
        L[lastY][lastX] = L[y][x]

for i in range(T):
    L = diffuse(L)
    air_purify(L)

result = 0
for i in L:
    for j in i:
        if j != -1:
            result += j
print (result)
import copy
from collections import deque

N, M = map(int, input().split())
L = [list(map(int, input().split())) for _ in range(N)]
L[0][0] = 0
L[N-1][M-1] = 0
vx = [0, 0, -1, 1]
vy = [-1, 1, 0, 0]

def melt(L):
    L_ = copy.deepcopy(L)
    for i in range(M):
        for j in range(N):
            if L[j][i] != 0:
                for k in range(4):
                    nx = j + vx[k]
                    ny = i + vy[k]

                    if not 0 <= nx < N or not 0 <= ny < M:
                        continue
                    if L[nx][ny] == 0 and L_[j][i] != 0:
                        L_[j][i] -= 1
    return L_

def check(L):
    visited = [[False]*M for _ in range(N)]
    q = deque()
    c = 0

    for i in range(M):
        for j in range(N):
            if L[j][i] != 0 and not visited[j][i]:
                q.append((j, i))
                while q:
                    cx, cy = q.popleft()

                    for k in range(4):
                        nx = cx + vx[k]
                        ny = cy + vy[k]

                        if not 0 <= nx < N or not 0 <= ny < M or visited[nx][ny]:
                            continue
                        if L[nx][ny] != 0:
                            visited[nx][ny] = True
                            q.append((nx, ny))
                c += 1
    return c

cnt = 0
while True:
    cnt += 1
    L = melt(L)
    t = check(L)
    if t == 0:
        print (0)
        break
    if t >= 2:
        print (cnt)
        break
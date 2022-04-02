import sys
from collections import deque

def bfs(lst, x, y, q_x, q_y, visited, k, v):
    q = deque()
    q.append([q_x, q_y, lst[q_y][q_x]])
    fence_cnt = {'k': 0, 'v': 0}

    if visited[q_y][q_x]:
        return k, v
    visited[q_y][q_x] = True

    dx = [0, 0, -1, 1]
    dy = [-1, 1, 0, 0]
    while q:
        tmpX, tmpY, tmpV = q.popleft()
        if tmpV.isalpha():
            fence_cnt[tmpV] += 1
           
        for i in range(4):
            nx = tmpX + dx[i]
            ny = tmpY + dy[i]
            if nx < 0 or nx >= x or ny < 0 or ny >= y:
                continue
            if lst[ny][nx] != '#' and not visited[ny][nx]:
                q.append([nx, ny, lst[ny][nx]])
                visited[ny][nx] = True

    if fence_cnt['k'] > fence_cnt['v']:
        k += fence_cnt['k']
    else:
        v += fence_cnt['v']           
    return k, v

r, c = map(int, sys.stdin.readline().split())
k, v = 0, 0
fence = []
visited = [[False]*c for _ in range(r)]
for _ in range(r):
    fence.append(list(map(str, sys.stdin.readline().strip())))
for i in range(r):
    for j in range(c):
        if fence[i][j].isalpha():
            k, v = bfs(fence, c, r, j, i, visited, k, v)

print(k, v)
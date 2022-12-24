from collections import deque

dx = [1, 1, 1, -1, -1, -1, 0, 0]
dy = [1, 0, -1, 1, 0, -1, 1, -1]


def bfs(x, y):
    queue = deque()
    queue.append((x, y))
    maps[x][y] = 0

    while queue:
        q = queue.popleft()
        for i in range(8):
            nx = q[0] + dx[i]
            ny = q[1] + dy[i]
            if 0 <= nx < h and 0 <= ny < w:
                if maps[nx][ny] == 1:
                    maps[nx][ny] = 0
                    queue.append((nx, ny))


while 1:
    w, h = map(int, input().split())
    maps = []
    answer = 0

    if w == h == 0:
        break

    for _ in range(h):
        maps.append(list(map(int, input().split())))

    for i in range(h):
        for j in range(w):
            if maps[i][j] == 1:
                answer += 1
                bfs(i, j)

    print(answer)
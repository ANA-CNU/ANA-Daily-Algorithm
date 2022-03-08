from collections import deque
input = __import__('sys').stdin.readline
if __name__ == "__main__":
    m, n = map(int, input().split())
    board = [[0]*m for _ in range(n)]
    for i in range(n):
        l = input().strip()
        for j in range(len(l)):
            board[i][j] = int(l[j])

    q = deque()
    q.append((0, 0))
    visit = [[False]*m for _ in range(n)]
    visit_crash = [[0]*m for _ in range(n)]
    visit[0][0] = True
    dst_x, dst_y = n - 1, m - 1
    dxdy = [(-1, 0), (1, 0), (0, -1), (0, 1)]
    while q:
        x, y = q.popleft()
        for d in dxdy:
            dx, dy = x + d[0], y + d[1]
            if 0<=dx<n and 0<=dy<m:
                if visit[dx][dy] == False:
                    visit[dx][dy] = True
                    if board[dx][dy] == 1:
                        visit_crash[dx][dy] = visit_crash[x][y] + 1
                    else:
                        visit_crash[dx][dy] = visit_crash[x][y]
                    q.append((dx, dy))
                else:
                    if board[dx][dy] == 1:
                       if visit_crash[dx][dy] > visit_crash[x][y] + 1:
                            visit_crash[dx][dy] = visit_crash[x][y] + 1
                            q.append((dx, dy))
                    else:
                        if visit_crash[dx][dy] > visit_crash[x][y]:
                            visit_crash[dx][dy] = visit_crash[x][y]
                            q.append((dx, dy))
    print(visit_crash[dst_x][dst_y])
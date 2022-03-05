input = __import__('sys').stdin.readline
if __name__ == "__main__":
    n, m = map(int, input().split())
    r, c, d = map(int, input().split())
    board = [list(map(int, input().split())) for _ in range(n)]
    visit = [[False]*m for _ in range(n)]

    # 북 0 동 1 남 2 서 3
    x, y = r, c
    visit[x][y] = True
    clean_count = 1
    turn_count = 0
    # L, U, R, D
    dxdy = [(0, -1), (-1, 0), (0, 1), (1, 0)]
    while True:
        if d == 0:
            if turn_count == 4:
                turn_count += 1
                dx, dy = x + dxdy[3][0], y + dxdy[3][1]
            else:
                dx, dy = x + dxdy[0][0], y + dxdy[0][1]
                d = 3
                turn_count += 1
        elif d == 1:
            if turn_count == 4:
                turn_count += 1
                dx, dy = x + dxdy[0][0], y + dxdy[0][1]
            else:
                dx, dy = x + dxdy[1][0], y + dxdy[1][1]
                d = 0
                turn_count += 1
        elif d == 2:
            if turn_count == 4:
                turn_count += 1
                dx, dy = x + dxdy[1][0], y + dxdy[1][1]
            else:
                dx, dy = x + dxdy[2][0], y + dxdy[2][1]
                d = 1
                turn_count += 1
        elif d == 3:
            if turn_count == 4:
                turn_count += 1
                dx, dy = x + dxdy[2][0], y + dxdy[2][1]
            else:
                dx, dy = x + dxdy[3][0], y + dxdy[3][1]
                d = 2
                turn_count += 1
        if 0<=dx<n and 0<=dy<m and visit[dx][dy] == False and board[dx][dy] == 0:
            x, y = dx, dy
            turn_count = 0
            visit[dx][dy] = True
            clean_count += 1
            continue
        if turn_count == 5:
            if 0<=dx<n and 0<=dy<m and board[dx][dy] == 0:
                x, y = dx, dy
                turn_count = 0
                continue
            else:
                break
    print(clean_count)
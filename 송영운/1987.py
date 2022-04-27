input = __import__('sys').stdin.readline
if __name__ == "__main__":
    r, c = map(int, input().split())
    board = [list(input().strip()) for _ in range(r)]
    ans = 0
    s_x, s_y = 0, 0
    s = set()
    s.add((s_x, s_y, 1, board[s_x][s_y]))
    dxdy = [(0, 1), (0, -1), (1, 0), (-1, 0)]
    while s:
        x, y, count, visit = s.pop()
        ans = max(ans, count)
        for d in dxdy:
            dx, dy = x + d[0], y + d[1]
            if 0<=dx<r and 0<=dy<c and board[dx][dy] not in visit:
                s.add((dx, dy, count+1, visit+board[dx][dy]))
    print(ans)
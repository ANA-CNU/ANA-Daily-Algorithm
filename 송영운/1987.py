from collections import deque
input = __import__('sys').stdin.readline
if __name__ == "__main__":
    r, c = map(int, input().split())
    board = [list(input().strip()) for _ in range(r)]
    ans = 0
    s_x, s_y = 0, 0
    stack = []
    stack.append((s_x, s_y, 1, board[s_x][s_y]))
    dxdy = [(0, 1), (0, -1), (1, 0), (-1, 0)]
    while stack:
        x, y, count, visit = stack.pop()
        ans = max(ans, count)
        for d in dxdy:
            dx, dy = x + d[0], y + d[1]
            if 0<=dx<r and 0<=dy<c and board[dx][dy] not in visit:
                stack.append((dx, dy, count+1, visit+board[dx][dy]))
    print(ans)
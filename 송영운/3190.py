# 0 u 1 d 2 r 3 l
def turn_left(n):
    if n == up_direction:
        return left_direction
    elif n == down_direction:
        return right_direction
    elif n == right_direction:
        return up_direction
    else:
        return down_direction
def turn_right(n):
    if n == up_direction:
        return right_direction
    elif n == down_direction:
        return left_direction
    elif n == right_direction:
        return down_direction
    else:
        return up_direction

# 0 u 1 d 2 r 3 l
up_direction = 0
down_direction = 1
right_direction = 2
left_direction = 3
start_x, start_y = 0, 0
dxdy = [(-1, 0), (1, 0), (0, 1), (0, -1)]
from collections import deque
input = __import__('sys').stdin.readline
if __name__ == "__main__":
    n = int(input())
    k = int(input())
    board = [[0]*n for _ in range(n)]
    for _ in range(k):
        x, y = map(int, input().split())
        x -= 1
        y -= 1
        board[x][y] = -1
    l = int(input())
    instructions = deque()
    for _ in range(l):
        t, direction = input().split()
        instructions.append((int(t), direction))
    tails = deque()
    tails.append((start_x, start_y))
    board[start_x][start_y] = 1
    ans = 0
    x, y, direction = start_x, start_y, right_direction
    while True:
        ans += 1
        dx, dy = x + dxdy[direction][0], y + dxdy[direction][1]
        if dx < 0 or dx >= n or dy < 0 or dy >= n:
            break
        if board[dx][dy] == 1:
            break
        if board[dx][dy] == -1:
            tails.append((dx, dy))
            board[dx][dy] = 1
        else:
            tails.append((dx, dy))
            board[dx][dy] = 1
            board[tails[0][0]][tails[0][1]] = 0
            tails.popleft()
        if len(instructions) != 0 and ans == instructions[0][0]:
            change_direction = instructions[0][1]
            instructions.popleft()
            if change_direction == 'L':
                direction = turn_left(direction)
            elif change_direction == 'D':
                direction = turn_right(direction)
        x, y = dx, dy
    print(ans)
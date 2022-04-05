import copy
import sys

def up(x, y):
    while x > 0:
        x -= 1
        if board[x][y] == 0:
            board[x][y] = -1
        elif board[x][y] == 6:
            break
def down(x, y):
    while x < n - 1:
        x += 1
        if board[x][y] == 0:
            board[x][y] = -1
        elif board[x][y] == 6:
            break
def right(x, y):
    while y < m - 1:
        y += 1
        if board[x][y] == 0:
            board[x][y] = -1
        elif board[x][y] == 6:
            break
def left(x, y):
    while y > 0:
        y -= 1
        if board[x][y] == 0:
            board[x][y] = -1
        elif board[x][y] == 6:
            break

def check(c):
    global min_num, board, n, m
    x, y = cctv[c]
    temp_board = copy.deepcopy(board)
    for i in range(4):
        if board[x][y] == 1:
            if i == 0:
                up(x, y)
            elif i == 1:
                right(x, y)
            elif i == 2:
                down(x, y)
            elif i == 3:
                left(x, y)
        elif board[x][y] == 2:
            if i == 0 or i == 2:
                up(x, y)
                down(x, y)
            elif i == 1 or i == 3:
                right(x, y)
                left(x, y)
        elif board[x][y] == 3:
            if i == 0:
                up(x, y)
                right(x, y)
            elif i == 1:
                down(x, y)
                right(x, y)
            elif i == 2:
                down(x, y)
                left(x, y)
            elif i == 3:
                up(x, y)
                left(x, y)
        elif board[x][y] == 4:
            if i == 0:
                up(x, y)
                right(x, y)
                left(x, y)
            elif i == 1:
                up(x, y)
                down(x, y)
                right(x, y)
            elif i == 2:
                down(x, y)
                right(x, y)
                left(x, y)
            elif i == 3:
                up(x, y)
                down(x, y)
                left(x, y)
        elif board[x][y] == 5:
            up(x, y)
            down(x, y)
            right(x, y)
            left(x, y)
        if c+1 < len(cctv):
            check(c+1)
        else:
            count = 0
            for i in range(n):
                for j in range(m):
                    if board[i][j] == 0:
                        count += 1
            min_num = min(min_num, count)
        board = copy.deepcopy(temp_board)

min_num = sys.maxsize
from collections import deque
input = __import__('sys').stdin.readline
if __name__ == "__main__":
    n, m = map(int, input().split())
    board = [list(map(int, input().split())) for _ in range(n)]
    # 1 up 2 right 3 down 4 left
    cctv = deque()
    for i in range(n):
        for j in range(m):
            if board[i][j] != 0 and board[i][j] != 6:
                cctv.append((i , j))
    if len(cctv) != 0:
        check(0)
        print(min_num)
    else:
        count = 0
        for i in range(n):
            for j in range(m):
                if board[i][j] == 0:
                    count += 1
        print(count)
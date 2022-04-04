import copy
import sys



def check(c):
    global min_num
    global board
    global n, m

    x, y = cctv[c]
    dx, dy = x, y
    temp_board = copy.deepcopy(board)
    for i in range(4):
        x, y = dx, dy
        if board[x][y] == 1:
            if i == 0:
                while x > 0:
                    x -= 1
                    if board[x][y] == 0:
                        board[x][y] = -1
                    elif board[x][y] == 6:
                        break
            elif i == 1:
                while y < m-1:
                    y += 1
                    if board[x][y] == 0:
                        board[x][y] = -1
                    elif board[x][y] == 6:
                        break
            elif i == 2:
                while x < n-1:
                    x += 1
                    if board[x][y] == 0:
                        board[x][y] = -1
                    elif board[x][y] == 6:
                        break
            elif i == 3:
                while y > 0:
                    y -= 1
                    if board[x][y] == 0:
                        board[x][y] = -1
                    elif board[x][y] == 6:
                        break
        elif board[x][y] == 2:
            if i == 0 or i == 2:
                while x > 0:
                    x -= 1
                    if board[x][y] == 0:
                        board[x][y] = -1
                    elif board[x][y] == 6:
                        break
                x = dx
                while x < n-1:
                    x += 1
                    if board[x][y] == 0:
                        board[x][y] = -1
                    elif board[x][y] == 6:
                        break
            elif i == 1 or i == 3:
                while y > 0:
                    y -= 1
                    if board[x][y] == 0:
                        board[x][y] = -1
                    elif board[x][y] == 6:
                        break
                y = dy
                while y < m-1:
                    y += 1
                    if board[x][y] == 0:
                        board[x][y] = -1
                    elif board[x][y] == 6:
                        break
        elif board[x][y] == 3:
            if i == 0:
                while x > 0:
                    x -= 1
                    if board[x][y] == 0:
                        board[x][y] = -1
                    elif board[x][y] == 6:
                        break
                x = dx
                while y < m-1:
                    y += 1
                    if board[x][y] == 0:
                        board[x][y] = -1
                    elif board[x][y] == 6:
                        break
            elif i == 1:
                while x < n-1:
                    x += 1
                    if board[x][y] == 0:
                        board[x][y] = -1
                    elif board[x][y] == 6:
                        break
                x = dx
                while y < m-1:
                    y += 1
                    if board[x][y] == 0:
                        board[x][y] = -1
                    elif board[x][y] == 6:
                        break
            elif i == 2:
                while x < n-1:
                    x += 1
                    if board[x][y] == 0:
                        board[x][y] = -1
                    elif board[x][y] == 6:
                        break
                x = dx
                while y > 0:
                    y -= 1
                    if board[x][y] == 0:
                        board[x][y] = -1
                    elif board[x][y] == 6:
                        break
            elif i == 3:
                while x > 0:
                    x -= 1
                    if board[x][y] == 0:
                        board[x][y] = -1
                    elif board[x][y] == 6:
                        break
                x = dx
                while y > 0:
                    y -= 1
                    if board[x][y] == 0:
                        board[x][y] = -1
                    elif board[x][y] == 6:
                        break
        elif board[x][y] == 4:
            if i == 0:
                while x > 0:
                    x -= 1
                    if board[x][y] == 0:
                        board[x][y] = -1
                    elif board[x][y] == 6:
                        break
                x = dx
                while y < m-1:
                    y += 1
                    if board[x][y] == 0:
                        board[x][y] = -1
                    elif board[x][y] == 6:
                        break
                x, y = dx, dy
                while y > 0:
                    y -= 1
                    if board[x][y] == 0:
                        board[x][y] = -1
                    elif board[x][y] == 6:
                        break
            elif i == 1:
                while x > 0:
                    x -= 1
                    if board[x][y] == 0:
                        board[x][y] = -1
                    elif board[x][y] == 6:
                        break
                x = dx
                while x < n-1:
                    x += 1
                    if board[x][y] == 0:
                        board[x][y] = -1
                    elif board[x][y] == 6:
                        break
                x = dx
                while y < m-1:
                    y += 1
                    if board[x][y] == 0:
                        board[x][y] = -1
                    elif board[x][y] == 6:
                        break
            elif i == 2:
                while x < n-1:
                    x += 1
                    if board[x][y] == 0:
                        board[x][y] = -1
                    elif board[x][y] == 6:
                        break
                x = dx
                while y < m-1:
                    y += 1
                    if board[x][y] == 0:
                        board[x][y] = -1
                    elif board[x][y] == 6:
                        break
                x, y = dx, dy
                while y > 0:
                    y -= 1
                    if board[x][y] == 0:
                        board[x][y] = -1
                    elif board[x][y] == 6:
                        break
            elif i == 3:
                while x > 0:
                    x -= 1
                    if board[x][y] == 0:
                        board[x][y] = -1
                    elif board[x][y] == 6:
                        break
                x = dx
                while x < n-1:
                    x += 1
                    if board[x][y] == 0:
                        board[x][y] = -1
                    elif board[x][y] == 6:
                        break
                x = dx
                while y > 0:
                    y -= 1
                    if board[x][y] == 0:
                        board[x][y] = -1
                    elif board[x][y] == 6:
                        break
        elif board[x][y] == 5:
            while x > 0:
                x -= 1
                if board[x][y] == 0:
                    board[x][y] = -1
                elif board[x][y] == 6:
                    break
            x = dx
            while x < n-1:
                x += 1
                if board[x][y] == 0:
                    board[x][y] = -1
                elif board[x][y] == 6:
                    break
            x = dx
            while y < m-1:
                y += 1
                if board[x][y] == 0:
                    board[x][y] = -1
                elif board[x][y] == 6:
                    break
            x, y = dx, dy
            while y > 0:
                y -= 1
                if board[x][y] == 0:
                    board[x][y] = -1
                elif board[x][y] == 6:
                    break
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
        exit()
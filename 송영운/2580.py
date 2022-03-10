xy_range = [(0,1,2), (3,4,5), (6,7,8)]
def check(x, y, num):
    for i in range(sudoku_size):
        if board[x][i] == num:
            return False
    for i in range(sudoku_size):
        if board[i][y] == num:
            return False
    if x<3:
        x_check = xy_range[0]
    elif x<6:
        x_check = xy_range[1]
    elif x<9:
        x_check = xy_range[2]
    if y<3:
        y_check = xy_range[0]
    elif y<6:
        y_check = xy_range[1]
    elif y<9:
        y_check = xy_range[2]
    for i in x_check:
        for j in y_check:
            if board[i][j] == num:
                return False
    return True

def fill(n):
    if n == len(fill_list):
        for i in range(sudoku_size):
            print(*board[i])
        exit()
    x, y = fill_list[n]
    for i in range(1, sudoku_size+1):
        if check(x, y, i):
            board[x][y] = i
            fill(n+1)
            board[x][y] = 0
        else:
            continue

input = __import__('sys').stdin.readline
sudoku_size = 9
if __name__ == "__main__":
    board = [list(map(int, input().split())) for _ in range(sudoku_size)]
    fill_list = []
    for i in range(sudoku_size):
        for j in range(sudoku_size):
            if board[i][j] == 0:
                fill_list.append((i, j))
    fill(0)
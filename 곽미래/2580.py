import sys

sudoku = []
for i in range(9):
    sudoku.append(list(map(int, sys.stdin.readline().split())))
zeros = [(i, j) for i in range(9) for j in range(9) if sudoku[i][j] == 0]


def find(row, col):
    missing_numbers=[1, 2, 3, 4, 5, 6, 7, 8, 9]
    for k in range(9):
        if sudoku[row][k] in missing_numbers:
            missing_numbers.remove(sudoku[row][k])
        if sudoku[k][col] in missing_numbers:
            missing_numbers.remove(sudoku[k][col])
    r_str = row//3 * 3
    c_str = col//3 * 3
    for i in range(r_str, r_str+3):
        for j in range(c_str, c_str+3):
            if sudoku[i][j] in missing_numbers:
                missing_numbers.remove(sudoku[i][j])
    return missing_numbers


def dfs(idx):
    if idx == len(zeros):
        for row in sudoku:
            print(*row)
        exit()

    else:
        row, col = zeros[idx]
        missing = find(row, col)
        for number in missing:
            sudoku[row][col] = number
            dfs(idx+1)
            sudoku[row][col] = 0


dfs(0)





import sys
n, m = map(int, sys.stdin.readline().rstrip().split())
board = [[0]*(n+1)]
for i in range(n):
    board.append([0] + list(map(int, sys.stdin.readline().rstrip().split())))
for i in range(1, n+1):
    for j in range(1, n+1):
        board[i][j] += board[i][j-1] + board[i-1][j] - board[i-1][j-1]
for i in range(m):
    x1, y1, x2, y2 = map(int, sys.stdin.readline().rstrip().split())
    print(board[x2][y2] - board[x2][y1-1] - board[x1-1][y2] + board[x1-1][y1-1])
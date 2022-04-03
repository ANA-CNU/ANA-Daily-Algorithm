def move(n):
    if n == 1:
        # 1 -> 3 -> 6 -> 4 -> 1
        temp = dice[3]
        dice[3] = dice[1]
        dice[1] = dice[4]
        dice[4] = dice[6]
        dice[6] = temp
    elif n == 2:
        # 1 -> 4 -> 6 -> 3 -> 1
        temp = dice[4]
        dice[4] = dice[1]
        dice[1] = dice[3]
        dice[3] = dice[6]
        dice[6] = temp
    elif n == 3:
        # 1 -> 2 -> 6 -> 5 -> 1
        temp = dice[2]
        dice[2] = dice[1]
        dice[1] = dice[5]
        dice[5] = dice[6]
        dice[6] = temp
    elif n == 4:
        # 1 -> 5 -> 6 -> 2 -> 1
        temp = dice[5]
        dice[5] = dice[1]
        dice[1] = dice[2]
        dice[2] = dice[6]
        dice[6] = temp

input = __import__('sys').stdin.readline
if __name__ == "__main__":
    n, m, x, y, k = map(int, input().split())
    board = [list(map(int, input().split())) for _ in range(n)]
    instructions = list(map(int, input().split()))
    #1:윗면 2:북 3:동 4:서 5:남 6:밑
    dice = [0]*(7)
    #1 동 2서 3 북 4 남
    dice[6] = board[x][y]
    dxdy = [(), (0, 1), (0, -1), (-1, 0), (1, 0)]
    for i in instructions:
        dx, dy = x + dxdy[i][0], y + dxdy[i][1]
        if 0<=dx<n and 0<=dy<m:
            x, y = dx, dy
            move(i)
            if board[x][y] == 0:
                board[x][y] = dice[6]
            else:
                dice[6] = board[x][y]
                board[x][y] = 0
            print(dice[1])
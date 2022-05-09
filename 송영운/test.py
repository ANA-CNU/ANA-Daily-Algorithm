from collections import deque

dxdy = [(0, 1), (1, 0), (0, -1), (-1, 0)]


def Rotate(rc):
    row_l = len(rc)
    col_l = len(rc[0])
    next_num = rc[0][0]
    for i in range(1, col_l):
        tmp = next_num
        next_num = rc[0][i]
        rc[0][i] = tmp
    for i in range(1, row_l):
        tmp = next_num
        next_num = rc[i][col_l - 1]
        rc[i][col_l - 1] = tmp
    for i in range(col_l - 1, -1, -1):
        tmp = next_num
        next_num = rc[row_l - 1][i]
        rc[row_l - 1][i] = tmp
    for i in range(row_l - 1, -1, -1):
        tmp = next_num
        next_num = rc[i][0]
        rc[i][0] = tmp


def ShiftRow(rc):
    row_l = len(rc)
    tmp = rc[row_l-1]
    for i in range(row_l-1, 0, -1):
        rc[i] = rc[i-1]
    rc[0] = tmp
    return rc

def solution(rc, operations):
    answer = [[]]
    for o in operations:
        if o == "Rotate":
            Rotate(rc)
        else:
            ShiftRow(rc)
    return rc

rc = [[1, 2, 3, 4], [4, 5, 6, 7], [7,8, 9, 10], [11, 12,13, 14], [15,16, 17, 18]]
l = len(rc)
print(rc)
ShiftRow(rc)
print(rc)
ShiftRow(rc)
print(rc)
Rotate(rc)
print(rc)
Rotate(rc)
print(rc)



[[11, 12, 13, 14],
 [15, 16, 17, 18],
 [1, 2, 3, 4],
 [4, 5, 6, 7],
 [7, 8, 9, 10]]

[[15, 11, 12, 13],
 [1, 16, 17, 14],
 [4, 2, 3, 18],
 [8, 5, 6, 4],
 [7, 9, 7, 10]]

[[1, 15, 11, 12],
 [4, 16, 17, 13],
 [8, 2, 3, 14],
 [9, 5, 6, 18],
 [7, 7, 4, 10]]
import sys
from collections import defaultdict

n, m, s = map(int, sys.stdin.readline().split())
game = [sys.stdin.readline().rstrip() for _ in range(n)]
trg = sys.stdin.readline().rstrip()

pos = defaultdict(list)

for i in range(n):
    for j in range(m):
        if not pos[game[i][j]]:
            pos[game[i][j]].append(1)
        pos[game[i][j]].append((i, j))

cnt_trg = defaultdict(int)
for t in trg:
    cnt_trg[t] += 1

min_cnt = n*m
for t in trg:
    min_cnt = min(min_cnt, (len(pos[t])-1) // cnt_trg[t])

res = ""
x, y = 0, 0
for _ in range(min_cnt):
    for t in trg:
        index = pos[t][0]
        (nx, ny) = pos[t][index]

        move_x = nx - x
        if move_x > 0:
            res += "D" * move_x
        else:
            res += "U" * abs(move_x)

        move_y = ny - y
        if move_y > 0:
            res += "R" * move_y
        else:
            res += "L" * abs(move_y)

        res += "P"

        pos[t][0] += 1
        x, y = nx, ny

move_x = n-1 - x
move_y = m-1 - y

if move_x > 0:
    res += "D" * move_x
else:
    res += 'U' * abs(move_x)

if move_y > 0:
    res += "R" * move_y
else:
    res += "L" * abs(move_y)

if min_cnt < 0:
    min_cnt = 0
print(min_cnt, len(res))
print(res)
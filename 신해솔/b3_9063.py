"""""""""
# 대지
"""""""""

import sys


n = int(sys.stdin.readline())
pos = [tuple(map(int, sys.stdin.readline().split())) for _ in range(n)]
x, y = zip(*pos)
max_x, min_x = max(x), min(x)
max_y, min_y = max(y), min(y)
area = (max_x - min_x) * (max_y - min_y)
print(area)
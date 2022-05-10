import sys
n = int(sys.stdin.readline())
paper = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]
result = []


def color(x, y, s):
    c = paper[x][y]
    for i in range(x, x+s):
        for j in range(y, y+s):
            if c != paper[i][j]:
                color(x, y, s//2)
                color(x, y+s//2, s//2)
                color(x+s//2, y, s//2)
                color(x+s//2, y+s//2, s//2)
                return
    if c == 0:
        result.append(0)
    else:
        result.append(1)


color(0, 0, n)
print(result.count(0))
print(result.count(1))
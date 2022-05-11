import sys
n = int(sys.stdin.readline())
paper = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]
result = []


def p(r, c, s):
    num = paper[r][c]
    for i in range(r, r+s):
        for j in range(c, c+s):
            if num != paper[i][j]:
                p(r, c, s//3)
                p(r, c+s//3, s//3)
                p(r, c+s//3*2, s//3)
                p(r+s//3, c, s//3)
                p(r+s//3, c+s//3, s//3)
                p(r+s//3, c+s//3*2, s//3)
                p(r+s//3*2, c, s//3)
                p(r+s//3*2, c+s//3, s//3)
                p(r+s//3*2, c+s//3*2, s//3)
                return
    if num == 0:
        result.append(0)
    elif num == 1:
        result.append(1)
    elif num == -1:
        result.append(-1)


p(0, 0, n)
print(result.count(-1))
print(result.count(0))
print(result.count(1))
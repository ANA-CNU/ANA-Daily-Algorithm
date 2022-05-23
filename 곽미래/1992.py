import sys
n = int(sys.stdin.readline())
img = [list(sys.stdin.readline().rstrip()) for _ in range(n)]
result = []


def compression(r, c, s):
    color = img[r][c]
    for i in range(r, r+s):
        for j in range(c, c+s):
            if color != img[i][j]:
                result.append("(")
                compression(r, c, s//2)
                compression(r, c+s//2, s//2)
                compression(r+s//2, c, s//2)
                compression(r+s//2, c+s//2, s//2)
                result.append(")")
                return
    if color == '0':
        result.append(0)
    else:
        result.append(1)


compression(0, 0, n)
print(*result, sep='')
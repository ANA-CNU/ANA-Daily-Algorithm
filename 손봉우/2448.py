import math

N = int(input())
K = int(math.log2(N//3))
arr = [[' '] * (2*N-1) for _ in range(N)]


def solve(depth, bx, by):
    if depth == 0:
        for i in range(3):
            for j in range(i*2+1):
                arr[by+i][bx+(2-i)+j] = '*'
        arr[by+1][bx+2] = ' '
    else:
        px = 2**(depth)*3
        py = 2**(depth-1)*3
        solve(depth-1, bx+px//2, by)
        solve(depth-1, bx, by+py)
        solve(depth-1, bx+px, by+py)
    
solve(K, 0, 0)
for i in arr:
    print (''.join(i))
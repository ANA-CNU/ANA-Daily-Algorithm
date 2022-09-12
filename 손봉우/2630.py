N = int(input())
L = []
result = [0, 0]

for i in range(N):
    L.append(list(map(int, input().split())))

def solve(sx, sy, ex, ey, a):
    temp = L[sx][sy]
    if a == 1:
        result[temp] += 1
        return
    
    flag = True
    for i in range(sy, sy+a):
        for j in range(sx, sx+a):
            if L[j][i] != temp:
                flag = False
                break
        if not flag: break
    
    if flag:
        result[temp] += 1
        return

    b = a//2

    solve(sx, sy, sx+b, sy+b, b)
    solve(sx+b, sy, sx+a, sy+b, b)
    solve(sx, sy+b, sx+b, sy+a, b)
    solve(sx+b, sy+b, sx+a, sy+a, b)

solve(0, 0, N, N, N)
print (result[0])
print (result[1])
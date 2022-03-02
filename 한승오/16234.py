dx = [0,0,1,-1]
dy = [1,-1,0,0]

def bfs(r, c):
    stk = [(r,c)]
    cases = [(r,c)]

    total = arr[r][c]
    cnt = 1

    while stk:
        cr, cc = stk.pop()
        for k in range(4):
            next_r = cr + dx[k]
            next_c = cc + dy[k]

            if 0 <= next_r < n and 0 <= next_c < n:
                if checks[next_r][next_c]:
                    continue

                if left <= abs(arr[cr][cc] - arr[next_r][next_c]) <= right:
                    stk.append((next_r,next_c))
                    cases.append((next_r,next_c))

                    total += arr[next_r][next_c]
                    cnt += 1
                    checks[next_r][next_c] = 1

    for row, col in cases:
        checks[row][col] = int(total / cnt)
    
    if len(cases) > 1:
        return True
    return False

n,left,right = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(n)]

days = 0

while True:
    flag = False
    checks = [[0 for _ in range(n)] for _ in range(n)]

    for i in range(n):
        for j in range(n):
            if not checks[i][j]:
                checks[i][j] = 1
                res = bfs(i,j)
                if not flag and res:
                    flag = True

    if not flag:
        break
    
    arr = checks
    days += 1

print(days)
N = int(input())
VID = []
for i in range(N):
    VID.append(list(input()))
result = ''

def solve(sx, sy, size):
    global result

    tmp = VID[sy][sx]
    flag = True
    for i in range(size):
        for j in range(size):
            if tmp != VID[sy+j][sx+i]:
                flag = False
                break
        if not flag: break
    if flag:
        print (sx, sy, size, tmp)
        result += str(tmp)
        return
    
    size //= 2
    
    result += '('
    solve(sx, sy, size)
    solve(sx+size, sy, size)
    solve(sx, sy+size, size)
    solve(sx+size, sy+size, size)
    result += ')'

solve(0, 0, N)
print (result)
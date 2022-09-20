N = int(input())
L = []
result = [0, 0, 0]
for i in range(N):
    L.append(list(map(int, input().split())))

def solve(x1, y1, a):
    flag = True
    x2, y2 = x1+a, y1+a

    temp = L[x1][y1]
    for i in range(x1, x2):
        for j in range(y1, y2):
            if temp != L[i][j]:
                flag = False
                break
        if not flag: break
    if flag:
        result[temp+1] += 1
        return
    else:
        a //= 3
        for i in range(3):
            for j in range(3):
                solve(x1+(a*i), y1+(a*j), a)

solve(0, 0, N)

for i in result:
    print (i)
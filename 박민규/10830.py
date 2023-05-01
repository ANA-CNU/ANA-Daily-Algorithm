# 행렬 제곱
n,m = map(int,input().split())
c = []

for i in range(n):
    c.append(list(map(int,input().split())))

def mul(x,y):
    res = [[0]*n for _ in range(n)]
    for i in range(n):
        for j in range(n):
            for k in range(n):
                res[i][j] += x[i][k]*y[k][j]%1000
    
    return res

def power(a,b):
    if b == 1:
        return a
    else:
        tmp = power(a,b//2)
        if b%2  == 0:
            return mul(tmp,tmp)
        else:
            return mul(mul(tmp,tmp),a)
        
result = power(c,m)

for row in result:
    for col in row:
        print(col%1000,end = ' ')
    print()
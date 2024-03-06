def a(y,x):
    if (x == 0) or (y == 0) :
        return 1
    else:
        return a(y-1,x) + a(y,x-1)

n,m,k = map(int,input().split())
last = n*m-1
x_last = last//m
y_last = last % m
if k == 0:
    print(a(x_last,y_last))
else:
    x_middle = (k-1)//m
    y_middle = (k-1) % m
    print(a(x_middle,y_middle)*a(x_last-x_middle, y_last-y_middle))


    [[sdfd],[sdfs],[sdf]]
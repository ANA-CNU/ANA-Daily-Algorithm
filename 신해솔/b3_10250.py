T = int(input())


for i in range(T):
    height, width, n = map(int, input().split())
    row = n//height + 1 if n % height != 0 else n//height
    column = n % height if n % height != 0 else height
    print(column*100 + row)

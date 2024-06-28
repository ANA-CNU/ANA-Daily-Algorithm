import sys
input = sys.stdin.readline
def back(ls,row,col):
    if len(ls)==col:
        for w in range(len(ls)):
            print(ls[w], end=' ')
        print()
        return 0
    for k in range(1,row+1):
        if k in ls :
            continue
        ls.append(k)
        back(ls,row,col)
        ls.pop()
    

row, col = map(int, input().split())
ls=[]
back(ls,row,col)
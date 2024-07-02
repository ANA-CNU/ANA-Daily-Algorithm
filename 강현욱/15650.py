import sys
input=sys.stdin.readline
def back(n, m, ls):
    check=0
    if len(ls)==m:
        
        for j in range(len(ls)-1):
                if ls[j]>ls[j+1]:
                    check=1
                    break
           
        if check == 0:
            for w in range(len(ls)):
                print(ls[w], end=' ')
            print()
    else:
        for k in range(1,n+1):
            if k in ls:
                continue
            ls.append(k)
            back(n,m,ls)
            ls.pop() 

n, m = map(int, input().split())
ls=[]
back(n, m, ls)
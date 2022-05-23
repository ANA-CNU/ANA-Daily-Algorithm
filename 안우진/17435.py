# 후속노드 succ(x,k)=succ(succ(x,k/2),k/2)

import sys;r=sys.stdin.readline
m=int(r())
f=[[0]*(m+1) for _ in range(19)]
tmp=r().split()
for i in range(m):
    f[0][i+1]=int(tmp[i])
for i in range(1,19):
    for j in range(1,m+1):
        f[i][j]=f[i-1][f[i-1][j]]
for i in range(int(r())):
    n,x=map(int,r().split())
    for j in range(19):
        if n&(1<<j):
            x=f[j][x]
    print(x)

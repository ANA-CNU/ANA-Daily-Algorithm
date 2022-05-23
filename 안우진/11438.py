import sys;r=sys.stdin.readline
from collections import deque
n=int(r())
C=17
f=[[0]*(n+1) for _ in range(C)]
lv=[-1]*(n+1);lv[1]=0
l=[[] for i in range(n+1)]
for i in range(n-1):
    a,b=map(int,r().split())
    l[a].append(b)
    l[b].append(a)
def bfs():
    q=deque([1])
    while q:
        x=q.popleft()
        for next in l[x]:
            if lv[next]!=-1: continue
            lv[next]=lv[x]+1
            f[0][next]=x
            q.append(next)
bfs()
for i in range(1,C):
    for j in range(1,n+1):
        f[i][j]=f[i-1][f[i-1][j]]
def ans(n,k):
    for i in range(C):
        if k&(1<<i):
            n=f[i][n]
    return n
def lca(a,b):
    if lv[a]>lv[b]:
        a=ans(a,lv[a]-lv[b])
    elif lv[a]<lv[b]:
        b=ans(b,lv[b]-lv[a])
    if a==b: return a
    for i in range(C-1,-1,-1):
        if f[i][a]!=f[i][b]:
            a=f[i][a]
            b=f[i][b]
    return f[0][a]
        
for i in range(int(r())):
    x,y=map(int,r().split())
    print(lca(x,y))
    

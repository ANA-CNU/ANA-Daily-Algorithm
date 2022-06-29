import sys;r=sys.stdin.readline
from collections import deque
def bfs():
    root=0
    for i in range(1,n+1):
        if lv[i]==0:
            root=i
            break
    q=deque([root])
    while q:
        x=q.popleft()
        for leaf in tree[x]:
            lv[leaf]=lv[x]+1
            q.append(leaf)
            parent[leaf]=x
for _ in range(int(r())):
    n=int(r())
    tree=[[] for i in range(n+1)]
    parent=[0]*(n+1)
    lv=[0]*(n+1)
    for i in range(n-1):
        a,b=map(int,r().split())
        tree[a].append(b)
        lv[b]=1
    bfs()
    a,b=map(int,r().split())
    if lv[b]<lv[a]:
        a,b=b,a
    if lv[a]!=lv[b]:
        for j in range(lv[b]-lv[a]):
            b=parent[b]
    if a==b:
        print(a)
        continue
    while a!=b:
        a=parent[a]
        b=parent[b]
    print(a)

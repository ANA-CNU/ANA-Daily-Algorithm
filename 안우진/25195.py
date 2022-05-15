import sys;r=sys.stdin.readline
from collections import deque
n,m=map(int,r().split())
l=[[] for i in range(n+1)]
for i in range(m):
    a,b=map(int,r().split())
    l[a].append(b)
r()
tmp=map(int,r().split())
s=[0]*(n+1)
for t in tmp:
    s[t]=1
if s[1]:
    print("Yes")
    exit()
def bfs():
    q=deque([1])
    while q:
        p=q.popleft()
        if len(l[p])==0:
            return False
        for next in l[p]:
            if s[next]: continue
            q.append(next)
    return True
if bfs(): print("Yes")
else: print("yes")

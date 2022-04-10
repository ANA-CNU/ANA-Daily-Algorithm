# BOJ 19535
# BFS

import sys;r=sys.stdin.readline
from collections import deque
N=int(r())
line=[[] for _ in range(N+1)]
visit=[0]*(N+1)
for i in range(N-1):
    a,b=map(int,r().split())
    line[a].append(b)
    line[b].append(a)
q=deque([1]); visit[1]=1
d=g=0
while q:
    n=q.popleft()
    l=len(line[n])
    if len(line[n])>=3:
        g+=l*(l-1)*(l-2)//6
    for next in line[n]:
        if not visit[next]:
            q.append(next)
            visit[next]=1
            d+=(l-1)*(len(line[next])-1)
if d>g*3: print('D')
elif d<g*3: print('G')
else: print('DUDUDUNGA')

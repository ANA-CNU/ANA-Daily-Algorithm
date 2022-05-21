# 한 쌍의 노드만 LCA 구하므로 O(N)으로 동작하게함.
# P5 LCA2처럼하면 TLE

import sys;r=sys.stdin.readline
from collections import deque
c=17
n=int(r())
s,c,h=map(int,r().split())
parent=[0]*(n+1)
graph=[[] for i in range(n+1)]
lv=[-1]*(n+1)
for i in range(n-1):
    a,b=map(int,r().split())
    graph[b].append(a)
    graph[a].append(b)
    
def bfs():
    lv[s]=0
    q=deque([s])
    while q:
        x=q.popleft()
        for next in graph[x]:
            if lv[next]!=-1: continue
            lv[next]=lv[x]+1
            parent[next]=x
            q.append(next)        
bfs()

def glca(a,b):
    if lv[a]>lv[b]:
        a,b=b,a
    if lv[a]!=lv[b]:
        for i in range(lv[b]-lv[a]):
            b=parent[b]
    while a!=b:
        a=parent[a]
        b=parent[b]
    return a
    
def c2(k):
    return k*(k-1)//2

t1=lv[c]+1
ch=glca(c,h)
t2=lv[c]+lv[h]-2*lv[ch]+1
t3=(lv[h]-lv[ch])*lv[ch]
print(c2(t1)+c2(t2)+t3)

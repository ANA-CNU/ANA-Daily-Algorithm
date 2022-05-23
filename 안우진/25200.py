# LinkedList O(1)에 합칠 수 있도록 함

class Node:
    def __init__(self,n,next):
        self.num=n
        self.next=next
        self.last=self

import sys;r=sys.stdin.readline
n,m=map(int,r().split())
p=[Node(i,None) for i in range(n+1)]
for i in range(m):
    a,b=map(int,r().split())
    if p[a]==None: continue
    if p[b]==None:
        p[b]=p[a]
        p[a]=None
        continue
    p[b].last.next=p[a]
    p[b].last=p[a].last
    p[a]=None
result=[0]*(n+1)
for i in range(1,n+1):
    if p[i]==None: continue
    cur=p[i]
    while cur!=None:
        result[cur.num]=i
        cur=cur.next
print(*result[1:],sep=" ")

# Tree dp dfs

import sys;r=sys.stdin.readline
sys.setrecursionlimit(10**8)
n,t,q=map(int,r().split())
l=[[] for i in range(n+1)]
for i in range(n-1):
    u,v=map(int,r().split())
    l[u].append(v)
    l[v].append(u)
visit=[0]*(n+1)
cnt=[0]*(n+1)
def dfs(x):
    visit[x]=1
    cnt[x]=1
    for i in l[x]:
        if visit[i]: continue
        dfs(i)
        cnt[x]+=cnt[i]
dfs(t)
for i in range(q):
    print(cnt[int(r())])

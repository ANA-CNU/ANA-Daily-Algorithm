# 이웃한 노드는 다른 색으로 칠함
# 초기상태는 모두 1번 색이고
# dfs 돌면서 이웃한 노드를 0번으로 칠함
# 1번 색과 0번 색의 개수 중 적은 개수를 출력

import sys;r=sys.stdin.readline
sys.setrecursionlimit(10**8)
n=int(r())
l=[[] for i in range(n+1)]
for i in range(n-1):
    u,v=map(int,r().split())
    l[u].append(v)
    l[v].append(u)
c=[1]*(n+1)
visit=[0]*(n+1)
color=0
def dfs(x):
    global color
    visit[x]=1
    for i in l[x]:
        if visit[i]: continue
        dfs(i)
        if c[i] and c[x]:
            c[x]=0
            color+=1
dfs(1)
print(min(color,n-color))

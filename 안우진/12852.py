# O(N)으로 하면 99%에서 TLE남
# BFS로 구현

from collections import deque
n=int(input())
dp=[0]*(n+1)
v=[1]*(n+1)
q=deque([n])
while q:
    x=q.popleft()
    if x==1: break
    if x%3==0 and not dp[x//3]:
        q.append(x//3)
        dp[x//3]=dp[x]+1
        v[x//3]=x
    if x%2==0 and not dp[x//2]:
        q.append(x//2)
        dp[x//2]=dp[x]+1
        v[x//2]=x
    if x>1 and not dp[x-1]:
        q.append(x-1)
        dp[x-1]=dp[x]+1
        v[x-1]=x
print(dp[1])
k=1
ans=[]
for i in range(dp[1]):
    ans.append(k)
    k=v[k]
print(n,end=" ")
for i in range(len(ans)-1,-1,-1):
    print(ans[i],end=" ")

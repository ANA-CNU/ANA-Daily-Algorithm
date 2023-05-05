from sys import stdin
from collections import deque
from copy import deepcopy
input = stdin.readline
n,m,r = map(int,input().rstrip('\n').split())

st= [ i for i in range(n)]
for i in range(n):
    st[i] = list(map(int,input().split()))
res = deepcopy(st)

SIZE = min(n,m)//2

for i in range(SIZE):
    # 0,0  -> 1,1 -> 2,2 -> 3,3 -> ...
    # i -- m - i
    # i+1 -- N - i
    deq = deque([])

    for j in range(i,m-i):
        deq.append(st[i][j])
    for j in range(i+1, n-i-1):
        deq.append(st[j][m-i-1])
    for j in range(m-i-1, i-1, -1):
        deq.append(st[n-i-1][j])
    for j in range(n-i-2,i,-1):
        deq.append(st[j][i])

    deq.rotate(-r)

    for j in range(i,m-i):
        res[i][j] = deq.popleft()
    for j in range(i+1, n-i-1):
        res[j][m-i-1] = deq.popleft()
    for j in range(m-i-1, i-1, -1):
        res[n-i-1][j] = deq.popleft()
    for j in range(n-i-2,i,-1):
        res[j][i] = deq.popleft()
for row in res:
    print(*row)





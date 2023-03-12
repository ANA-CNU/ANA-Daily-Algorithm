#백준 1697번 숨바꼭질
from collections import deque
import sys
input = sys.stdin.readline

n,k = map(int,input().split())
d = [0]*100001

def bfs(x):
    q = deque()
    q.append(x)

    while q:
        x = q.popleft()
        if x == k:
            return d[x]
        for i in (x-1,x+1,2*x):
            if 0<= i < 100001 and not d[i]:
                d[i] = d[x] + 1
                q.append(i)
print(bfs(n))
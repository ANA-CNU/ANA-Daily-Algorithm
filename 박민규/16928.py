#백준 16928번 뱀과 사다리 게임
from collections import deque
import sys
input = sys.stdin.readline

n,m = map(int,input().split())
move = [0]*101
visited = [False]*101

for i in range(n+m):
    x,y = map(int,input().split())
    move[x] = y
q = deque()
q.append((1,0))
visited[1] = True

while q:
    now ,cnt = q.popleft()

    if now == 100:
        print(cnt)
        break
    for i in range(1,7):
        next = now + i

        if next > 100:
            continue
        if visited[next]:
            continue
        visited[next] = True

        if move[next] != 0:
            next = move[next]

        q.append((next,cnt+1))
import sys
from collections import deque

F, S, G, U, D = map(int, sys.stdin.readline().split())
visit = [False] * (F+1)

def bfs():
    if S==G: return 0
    q = deque()
    q.append ((S, 0))
    visit[S] = True

    while q:
        cur, cnt = q.popleft()
        if cur == G:
            return cnt
        for i in (cur+U, cur-D):
            if 1 <= i <= F and not visit[i]:
                visit[i] = True
                q.append((i, cnt+1))
    return 'use the stairs'

print(bfs())
import sys
from collections import deque
n, m = map(int, sys.stdin.readline().split())
q = deque([i for i in range(1, n+1)])
cnt = 0
choose = deque(list(map(int, sys.stdin.readline().split())))
while len(choose) > 0:
    aim = choose.popleft()
    move_left = q.index(aim)
    move_right = len(q) - move_left
    if move_left <= move_right:
        cnt += move_left
        for i in range(move_left):
            q.append(q.popleft())
        q.popleft()
    else:
        cnt += move_right
        for i in range(move_right):
            q.appendleft(q.pop())
        q.popleft()
print(cnt)

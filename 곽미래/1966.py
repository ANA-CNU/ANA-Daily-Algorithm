import sys
from collections import deque
t = int(sys.stdin.readline())
for _ in range(t):
    n, m = map(int, sys.stdin.readline().split())
    numbers = list(map(int, sys.stdin.readline().split()))
    q = deque()
    idx = deque()
    for i in range(len(numbers)):
        q.append(numbers[i])
        idx.append(i)
    cnt = 0
    while len(q) > 0:
        if q[0] == max(q):
            cnt += 1
            if idx[0] == m:
                print(cnt)
                break
            else:
                q.popleft()
                idx.popleft()
        else:
            temp = q.popleft()
            index = idx.popleft()
            q.append(temp)
            idx.append(index)


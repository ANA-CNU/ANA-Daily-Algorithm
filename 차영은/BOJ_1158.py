import sys
from collections import deque

n, k = map(int, sys.stdin.readline().strip().split())
deq = deque([i for i in range(1, n + 1)])
ans = ['' for _ in range(n)]
idx = 0

while deq:
    for _ in range(k - 1):
        deq.append(deq.popleft())

    ans[idx] = str(deq.popleft())
    idx += 1

print('<', ', '.join(ans)[:], '>', sep='')

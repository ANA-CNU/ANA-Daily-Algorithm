import sys
from collections import deque

n = int(sys.stdin.readline())
queue = deque(i for i in range(1, n + 1))
ans = [0 for _ in range(n)]
idx = 0

while queue:
    ans[idx] = queue.popleft()

    if queue:
        queue.append(queue.popleft())

    idx += 1

print(*ans)

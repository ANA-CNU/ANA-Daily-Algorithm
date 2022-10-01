import sys
from collections import deque

N = int(sys.stdin.readline())
deq = deque(enumerate(map(int, sys.stdin.readline().strip().split())))
ans = []

while deq:
    idx, num = deq.popleft()
    ans.append(idx + 1)

    if num > 0:
        deq.rotate(-(num - 1))
    elif num < 0:
        deq.rotate(-num)

print(*ans)

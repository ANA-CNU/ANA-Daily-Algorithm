import sys
from collections import deque

while True:
    arr = list(map(int, sys.stdin.readline().split()))[1:] + [0]
    if len(arr) == 1 and arr[0] == 0:
        break
    stack = deque()
    ans = 0
    for i, e in enumerate(arr):
        k = i
        while stack and stack[-1][1] > e:
            k, prev = stack.pop()
            ans = max(ans, (i - k) * prev)
        stack.append((k, e))
    # print(stack)
    print(ans)
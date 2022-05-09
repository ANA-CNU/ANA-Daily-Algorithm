import sys
from collections import deque
t = int(sys.stdin.readline())
for _ in range(t):
    order = list(sys.stdin.readline())
    n = int(sys.stdin.readline())
    d = deque(sys.stdin.readline().rstrip()[1:-1].split(','))
    if n == 0:
        d = deque()
    is_front = True
    is_error = False
    for o in order:
        if o == "R":
            is_front = not is_front
        elif o == "D":
            if len(d) == 0:
                print("error")
                is_error = True
                break
            if is_front:
                d.popleft()
            else:
                d.pop()

    if not is_error:
        if not is_front:
            d.reverse()
        print("[" + ",".join(d) + "]")

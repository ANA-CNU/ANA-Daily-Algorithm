import sys
from collections import deque

day = 0

while True:
    p = int(sys.stdin.readline())
    parties = deque()
    day += 1

    if p == 0:
        break

    for _ in range(p):
        s, e = map(int, sys.stdin.readline().strip().split())
        parties.append((s, e - 1))

    parties = sorted(parties, key=lambda x: (x[1], -x[0]))

    ans = 0

    for t in range(8, 24):
        for i in range(2):
            for p in range(len(parties)):
                if parties[p][0] <= t <= parties[p][1]:
                    ans += 1
                    parties.pop(p)
                    break

    print(f"On day {day} Emma can attend as many as {ans} parties.")

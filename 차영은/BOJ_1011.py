import sys

N = int(sys.stdin.readline())

for _ in range(N):
    x, y = map(int, sys.stdin.readline().strip().split())
    dis = y - x
    cnt = 0
    move = 1
    tot = 0

    while tot < dis:
        cnt += 1
        tot += move

        if cnt % 2 == 0:
            move += 1

    print(cnt)

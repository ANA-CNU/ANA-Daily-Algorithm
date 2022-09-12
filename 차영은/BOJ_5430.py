import sys
from collections import deque

n = int(sys.stdin.readline())

for _ in range(n):
    d = deque()
    cmd = list(sys.stdin.readline().strip())
    length = int(sys.stdin.readline())
    inp = sys.stdin.readline().strip("[""]\n")
    lst = inp.split(",")
    R = 0
    D = 0
    error = False

    for i in lst:
        if i == '':
            break
        d.append(i)

    for i in cmd:
        if i == 'R':
            R += 1
        elif i == 'D' and not d:
            error = True
            break
        else:
            if R % 2 == 0:
                d.popleft()
            else:
                d.pop()

    if R % 2 == 1:
        d.reverse()

    if error:
        print('error')
    else:
        print('[', end='')

        for i in range(len(d)):
            print(d[i], end='')

            if i != len(d) - 1:
                print(',', end='')

        print(']')

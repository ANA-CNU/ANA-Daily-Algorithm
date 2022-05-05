import sys
n = int(sys.stdin.readline())
q = []
frt = 0
for i in range(n):
    order = sys.stdin.readline().rstrip().split()
    if order[0] == "push":
        q.append(order[1])
    elif order[0] == "pop":
        if frt < len(q):
            print(q[frt])
            frt += 1
        else:
            q = []
            frt = 0
            print(-1)
    elif order[0] == "size":
        print(len(q) - frt)
    elif order[0] == "empty":
        if frt < len(q):
            print(0)
        else:
            q = []
            frt = 0
            print(1)
    elif order[0] == "front":
        if frt < len(q):
            print(q[frt])
        else:
            print(-1)
    elif order[0] == "back":
        if frt < len(q):
            print(q[-1])
        else:
            print(-1)
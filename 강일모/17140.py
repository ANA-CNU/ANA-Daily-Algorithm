# boj 17140
from collections import Counter
import sys

R, C, K = map(int, input().split())

A = []
for _ in range(3):
    A.append(list(map(int, input().split())))

def Operation():
    global A
    length = -1

    if len(A) < len(A[0]):
        A = list(zip(*A))

        for i in range(len(A)):
            temp = list(filter(lambda x : x > 0, A[i]))
            temp = Counter(temp).most_common()
            temp.sort(key=lambda x : (x[1], x[0]))
            
            A[i] = []
            for t in temp:
                A[i].append(t[0])
                A[i].append(t[1])

            length = max(length, len(A[i]))

        for r in A:
            t = len(r)
            while t < length:
                r.append(0)
                t += 1

        A = list(zip(*A))

    else:
        for i in range(len(A)):
            temp = list(filter(lambda x : x > 0, A[i]))
            temp = Counter(temp).most_common()
            temp.sort(key=lambda x : (x[1], x[0]))
            
            A[i] = []
            for t in temp:
                A[i].append(t[0])
                A[i].append(t[1])

            length = max(length, len(A[i]))

        for r in A:
            t = len(r)
            while t < length:
                r.append(0)
                t += 1
            

try:
    if A[R-1][C-1] == K:
            print(0)
            sys.exit(0)
except IndexError:
    pass

find = False

for t in range(1, 101):
    Operation()
    try:
        if A[R-1][C-1] == K:
            print(t)
            find = True
            break
    except IndexError:
        pass

if not find:
    print(-1)
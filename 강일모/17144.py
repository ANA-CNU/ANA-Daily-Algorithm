# BOJ 17144
import sys
from collections import deque

R, C, T = map(int, sys.stdin.readline().split())

A = []

purifier = []

for i in range(R):
    A.append(deque(map(int, sys.stdin.readline().split())))

idx = 0
while idx < R:
    if A[idx][0] == -1:
        purifier.append((idx, 0))
        purifier.append((idx+1, 0))
        idx += 2
    else:
        idx += 1


def diffusion():
    global A
    dr = [-1, 1, 0, 0]
    dc = [0, 0, -1, 1]

    temp = [ [0 for _ in range(C)] for _ in range(R) ]

    for i in range(R):
        for j in range(C):
            if A[i][j] != -1:
                amount = (A[i][j] // 5)
                for k in range(4):
                    nr = i + dr[k]
                    nc = j + dc[k]

                    if (nr, nc) in purifier:
                        pass

                    elif (0<=nr<R) and (0<=nc<C):
                        A[i][j] -= amount
                        temp[nr][nc] += amount
    for i in range(R):
        for j in range(C):
            A[i][j] += temp[i][j]

def circulation():
    global A
    global purifier
    for i in range(len(purifier)):
        if not(i % 2):
            #CounterClockwise
            puriRow = purifier[i][0]
            A[puriRow].popleft()
            A[puriRow].appendleft(0)
            A[puriRow].appendleft(-1)

            temp = deque([])
            for i in range(puriRow, 0, -1):
                temp.append(A[i].pop())

            for i in range(puriRow-1, -1, -1):
                A[i].append(temp.popleft())

            temp = deque([])
            for i in range(0, puriRow):
                temp.append(A[i].popleft())

            for i in range(1, puriRow):
                A[i].appendleft(temp.popleft())

            
        else:
            #Clockwise
            puriRow = purifier[i][0]
            A[puriRow].popleft()
            A[puriRow].appendleft(0)
            A[puriRow].appendleft(-1)

            temp = deque([])
            for i in range(puriRow, R-1):
                temp.append(A[i].pop())

            for i in range(puriRow+1, R):
                A[i].append(temp.popleft())

            temp = deque([])
            for i in range(R-1, puriRow, -1):
                temp.append(A[i].popleft())

            for i in range(R-2, puriRow, -1):
                A[i].appendleft(temp.popleft())

for _ in range(T):
    diffusion()
    circulation()    

res = len(purifier)
for i in A:
    res += sum(i)


print(res)

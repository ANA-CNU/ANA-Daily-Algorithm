# BOJ 16235

import sys
from collections import deque

N, M, K = map(int, sys.stdin.readline().split())

# AOrigin = A[r][c]

AOrigin = []

for _ in range(N):
    AOrigin.append(list(map(int, sys.stdin.readline().split())))

# Remainder Nutrition

A = [ [5 for _ in range(N)] for _ in range(N) ]

wood = [ [deque([]) for _ in range(N)] for _ in range(N) ]

for _ in range(M):
    r, c, age = map(int, sys.stdin.readline().split())
    wood[r-1][c-1].append([age, True])

def ss():
    global A
    global wood
    nutrient = 0

    for i in range(N):
        for j in range(N):
            temp = deque([])
            while wood[i][j]:
                w = wood[i][j].popleft()
                if (A[i][j] >= w[0]):
                    A[i][j] -= w[0] # A tree consumes nutrients according to its age.
                    w[0] += 1
                    temp.append(w)
                else:
                    nutrient += (w[0] // 2) # In Summer, Refill nutrients according to age of dead tree.
        
            
            A[i][j] += nutrient
            nutrient = 0
            wood[i][j] = temp
            
def fw():
    global A
    global wood

    for i in range(N):
        for j in range(N):
            for w in wood[i][j]:
                if not(w[0] % 5) and w[1]:
                    if (j-1) >= 0:
                        wood[i][j-1].appendleft([1, True])
                    if (j+1) < N:
                        wood[i][j+1].appendleft([1, True])

                    if (i-1) >= 0:
                        wood[i-1][j].appendleft([1, True])
                        if (j-1) >= 0:
                            wood[i-1][j-1].appendleft([1,True])
                        if (j+1) < N:
                            wood[i-1][j+1].appendleft([1, True])

                    if (i+1) < N:
                        wood[i+1][j].appendleft([1, True])
                        if (j-1) >= 0:
                            wood[i+1][j-1].appendleft([1, True])
                        if (j+1) < N:
                            wood[i+1][j+1].appendleft([1, True])

            A[i][j] += AOrigin[i][j]
result = 0

for i in range(K):
    ss()
    fw()

for i in range(N):
    for j in range(N):
        result += len(wood[i][j])

print(result)
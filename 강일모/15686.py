# BOJ 15686
from itertools import combinations

def calcDistance(p1, p2):
    return abs(p1[0]-p2[0]) + abs(p1[1]-p2[1])

def calcCityChickenDist(chicken, house):
    result = 0

    for h in house:
        shortestChicken = int(1e9)
        for c in chicken:
            shortestChicken = min(shortestChicken, calcDistance(c, h))

        result += shortestChicken

    return result

N, M = map(int, input().split())

board = []
chicken = [] 
house = []

for i in range(N):
    board.append(list(map(int, input().split())))
    for j in range(N):
        if board[i][j] == 2:
            chicken.append((i,j))
        elif board[i][j] == 1:
            house.append((i,j))

min_value = int(1e9)

for i in range(1,M+1):
    for c in combinations(chicken, i):
        newchicken = set(c)
        min_value = min(min_value, calcCityChickenDist(newchicken, house))
        
print(min_value)

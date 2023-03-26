#파스칼의 삼각형
import sys

n, k = map(int, sys.stdin.readline().split())

triangle = [[0] * i for i in range(1, n+1)]
triangle[0][0] = 1
for i in range(1, n):
    for j in range(i+1):
        if j == 0 or j == i:
            triangle[i][j] = 1
        else:
            triangle[i][j] = triangle[i-1][j-1] + triangle[i-1][j]

print(triangle[n-1][k-1])
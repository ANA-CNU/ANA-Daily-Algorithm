# 백준  11049번 행렬곱
import sys
input = sys.stdin.readline

n = int(input())
arr = [list(map(int,input().split())) for _ in range(n)]

d = [[0 for i in range(n)] for _ in range(n)]

for i in range(n-1):
    d[i][i+1] = arr[i][0]*arr[i+1][0]*arr[i+1][1]

def dp(start,end):
    if d[start][end] != 0:
        return d[start][end]
    if start == end:
        return 0
    
    r = float("inf")
    for i in range(start,end):
        result = dp(start,i) + dp(i+1,end) + arr[start][0]*arr[i+1][0]*arr[end][1]

        if r > result:
            r = result
    d[start][end] = r
    return r

print(dp(0,n-1))
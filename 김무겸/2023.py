import math
import sys
input = sys.stdin.readline

def DFS(num, cnt):
    if cnt == n - 1:
        print(num)
        return

    for i in range(1, 10):
        flag = True
        x = num * 10 + i
        for i in range(2, int(math.sqrt(x)) + 1):
            if x % i == 0:
                flag = not flag
                break
        if flag:
            DFS(x, cnt + 1)

n = int(input())
DFS(2, 0)
DFS(3, 0)
DFS(5, 0)
DFS(7, 0)
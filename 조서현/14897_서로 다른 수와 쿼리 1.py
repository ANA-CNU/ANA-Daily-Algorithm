import math
import sys

# sys.stdin = open('tools/testcase.txt', 'r')

n = int(input())
sqrt_n = int(math.sqrt(n))
arr = list(map(int, input().split()))
m = int(input())
queries = [list(map(lambda x: int(x) - 1, sys.stdin.readline().split())) for i in range(m)]

compressed = dict()
idx = 0
for i in range(n):
    if arr[i] not in compressed.keys():
        compressed[arr[i]] = idx
        arr[i] = idx
        idx += 1
    else:
        arr[i] = compressed[arr[i]]
del compressed
pi = 0
pj = -1
dic = [0] * 1000001
cnt = 0
idx = 0
for q in sorted(queries, key=lambda x: (x[0] // sqrt_n, x[1])):
    i, j = q
    if idx == 0:
        pi = pj = i
        dic[arr[pi]] = 1
        cnt = 1
    while pi < i:
        dic[arr[pi]] -= 1
        if dic[arr[pi]] == 0:
            cnt -= 1
        pi += 1
    while pi > i:
        pi -= 1
        dic[arr[pi]] += 1
        if dic[arr[pi]] == 1:
            cnt += 1
    while pj < j:
        pj += 1
        dic[arr[pj]] += 1
        if dic[arr[pj]] == 1:
            cnt += 1
    while pj > j:
        dic[arr[pj]] -= 1
        if dic[arr[pj]] == 0:
            cnt -= 1
        pj -= 1
    q.append(cnt)
    idx += 1

print(*map(lambda x: x[-1], queries), sep='\n')
# https://www.acmicpc.net/problem/14897
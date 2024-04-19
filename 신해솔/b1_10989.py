"""""""""
# 수 정렬하기 3
"""""""""

import sys


n = int(sys.stdin.readline())
arr = [0] * 10001

for _ in range(n):
    num = int(sys.stdin.readline())
    arr[num] += 1

for i in range(10001):
    if arr[i]:
        for j in range(arr[i]):
            print(i)

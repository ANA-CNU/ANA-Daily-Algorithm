# 출입 기록 - 27111

import sys

n = int(sys.stdin.readline())
arr = set()
error = 0
for _ in range(n):
    a, b = tuple(map(int, sys.stdin.readline().split()))
    if b == 1:
        if a not in arr:
            arr.add(a)
        else:
            error += 1
    else:
        if a in arr:
            arr.remove(a)
        else:
            error += 1
error += len(arr)
print(error)

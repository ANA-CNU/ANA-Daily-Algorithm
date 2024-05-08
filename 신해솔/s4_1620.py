# 나는야 포켓몬 마스터 이다솜 - 1620

import sys

n, m = map(int, sys.stdin.readline().split())
arr = [sys.stdin.readline().rstrip() for _ in range(n)]
for _ in range(m):
    obj = sys.stdin.readline().rstrip()
    try:
        print(arr[int(obj)-1])
    except ValueError:
        print(arr.index(obj)+1)

import sys
from itertools import combinations_with_replacement

n, m = map(int, sys.stdin.readline().split())
arr = [i for i in range(1, n + 1)]

for i in list(combinations_with_replacement(arr, m)):
    print(*i)

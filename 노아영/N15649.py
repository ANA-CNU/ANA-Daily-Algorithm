import sys
from itertools import permutations
n, m = map(int, sys.stdin.readline().split())
a = []
for i in permutations(range(1, n+1), m):
    a.append(i)
a.sort()
for j in a:
    for k in j:
        print(k, end=" ")
    print()
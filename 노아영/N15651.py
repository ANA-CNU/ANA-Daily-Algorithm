import sys
from itertools import product
n, m = map(int, sys.stdin.readline().split())
a = list(product(range(1, n+1), repeat=m))
a.sort()
for i in a:
    for j in i:
        print(j, end=" ")
    print()
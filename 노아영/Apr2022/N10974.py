import sys
from itertools import permutations
n = int(sys.stdin.readline())
per = permutations(range(1, n+1), n)
for i in sorted(per):
    for j in i:
        print(j, end=" ")
    print()
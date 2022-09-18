import sys

n, m = map(int, sys.stdin.readline().split())
set1 = set(map(int, sys.stdin.readline().split()))
set2 = set(map(int, sys.stdin.readline().split()))
cpy_set2 = list(set2)

for i in set1:
    if i in set2:
        set2.remove(i)

for i in cpy_set2:
    if i in set1:
        set1.remove(i)

print(len(set2) + len(set1))

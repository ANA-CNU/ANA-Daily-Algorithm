import sys
from collections import Counter
n, c = map(int, sys.stdin.readline().split())
lst = list(map(int, sys.stdin.readline().split()))
lst = Counter(lst).most_common(n)
for i in lst:
    for _ in range(i[1]):
        print(i[0], end=" ")
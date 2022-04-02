from collections import Counter
import sys
n = int(sys.stdin.readline())
s_nums = list(map(int, sys.stdin.readline().split()))
m = int(sys.stdin.readline())
ans = list(map(int, sys.stdin.readline().split()))

c = Counter(s_nums)
for i in ans:
    print(c[i], end=' ')
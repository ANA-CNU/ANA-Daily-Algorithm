import sys
from collections import Counter
n = int(sys.stdin.readline())
w = []
for _ in range(n):
    w.append(sys.stdin.readline().strip())
ans_i, ans_j = "", 0
for i, j in Counter(w).items():
    if ans_i < i and ans_j <= j:
        ans_i, ans_j = i, j
print(ans_i, ans_j)
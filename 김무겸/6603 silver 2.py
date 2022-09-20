from collections import deque
from itertools import combinations
import sys

input = sys.stdin.readline
while True:
    arr = deque(map(int, input().split()))
    if len(arr) == 1:
        exit(0)
    x = arr.popleft()
    for sol in combinations(arr, 6):
        print(*sol)
    print()
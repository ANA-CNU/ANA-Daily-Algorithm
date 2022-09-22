import sys
from itertools import combinations

l, c = map(int, sys.stdin.readline().strip().split())
arr = sys.stdin.readline().strip().split()
arr.sort()
vowel = ['a', 'e', 'i', 'o', 'u']

for i in list(combinations(arr, l)):
    v_cnt = 0
    c_cnt = 0

    for j in i:
        if j in vowel:
            v_cnt += 1
        else:
            c_cnt += 1

    if v_cnt >= 1 and c_cnt >= 2:
        print(*i, sep='')

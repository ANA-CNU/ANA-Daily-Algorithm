import sys
from itertools import combinations
input = sys.stdin.readline

N, M = map(int, input().split())
arr = input().strip().split()
arr.sort()
vowel = []
for v in arr:
    if v in ['a', 'e', 'i', 'o', 'u']:
        vowel.append(v)
arr = [i for i in arr if i not in vowel]
ans = []
vowel.sort()
for i in range(1, len(vowel) + 1):
    vow = [v for v in combinations(vowel, i)]
    if N - i < 2:
        break
    a = [b for b in combinations(arr, N - i)]
    for j in vow:
        for k in a:
            ans.append(sorted(list(j) + list(k)))
ans.sort()
for i in ans:
    print("".join(i))
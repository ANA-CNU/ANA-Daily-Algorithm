import sys
nA, nB = map(int, sys.stdin.readline().split())

aL = set(map(int, sys.stdin.readline().split()))
bL = set(map(int, sys.stdin.readline().split()))
ans = sorted(list(aL-bL))
print(len(ans))
for i in ans:
    print(i, end=' ')
import sys

N = int(sys.stdin.readline())
s = set(map(int, sys.stdin.readline().split()))
print(*sorted(s))

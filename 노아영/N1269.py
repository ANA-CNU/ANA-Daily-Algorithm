import sys
a, b = map(int, sys.stdin.readline().split())
a_l = set(map(int, sys.stdin.readline().split()))
b_l = set(map(int, sys.stdin.readline().split()))
print(len(a_l^b_l))
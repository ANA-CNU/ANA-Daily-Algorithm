import sys
n = int(sys.stdin.readline())
for i in range(n):
    a, b = map(int, sys.stdin.readline().split())
    if a < b:
        bigger, smaller = b, a
    else:
        bigger, smaller = a, b

    while smaller != 0:
        bigger, smaller = smaller, bigger % smaller
    print(a*b//bigger)
import sys

T = int(input())

for i in range(T):
    R, P = map(str, sys.stdin.readline().split())

    for j in P:
        print(j * int(R), end='')

    print()

import sys

if __name__ == '__main__':
    N, L = map(int, sys.stdin.readline().rstrip().split(" "))
    hs = list(map(int, sys.stdin.readline().rstrip().split(" ")))

    hs.sort()

    for h in hs:
        if h <= L:
            L += 1

    print(L)
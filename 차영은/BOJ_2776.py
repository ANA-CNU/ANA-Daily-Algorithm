import sys

t = int(sys.stdin.readline())

for _ in range(t):
    n = int(sys.stdin.readline())
    arr1 = map(int, sys.stdin.readline().strip().split())
    dic = {}

    for i in arr1:
        dic[i] = 1

    m = int(sys.stdin.readline())
    arr2 = map(int, sys.stdin.readline().strip().split())

    for i in arr2:
        if i in dic:
            print(1)
        else:
            print(0)

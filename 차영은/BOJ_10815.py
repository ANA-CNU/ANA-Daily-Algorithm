import sys

n1 = int(sys.stdin.readline())
arr1 = map(int, sys.stdin.readline().split())
n2 = int(sys.stdin.readline())
arr2 = map(int, sys.stdin.readline().split())
dic = {}

for i in arr1:
    dic[i] = 1

for i in arr2:
    ans = dic.get(i)

    if ans is None:
        print(0, end=' ')
    else:
        print(ans, end=' ')

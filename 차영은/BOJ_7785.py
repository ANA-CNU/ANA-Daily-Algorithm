import sys

N = int(sys.stdin.readline())
dic = {}
arr = []

for _ in range(N):
    n, m = map(str, sys.stdin.readline().split())

    if m == 'enter':
        dic[n] = 1
    else:
        dic[n] = 0

for i in dic.keys():
    if dic[i] == 1:
        arr.append(i)

arr.sort(reverse=True)

for i in arr:
    print(i)

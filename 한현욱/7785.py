import sys
n = int(input())
arr = []
for i in range(n):
    a,b = sys.stdin.readline().rstrip('\n').split()
    if b == "enter":
        arr.append(a)
    else:
        del arr[arr.index(a)]
arr.sort()
for i in range(len(arr)):
    sys.stdout.write(arr[-i-1]+'\n')


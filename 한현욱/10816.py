import sys
m = int(sys.stdin.readline())
arr1 = list(map(int,sys.stdin.readline().split()))
n = int(sys.stdin.readline())
arr2 = list(map(int, sys.stdin.readline().split()))
dict = {}
for i in range(len(arr2)):
    dict[arr2[i]] = 0
for i in arr1:
    try:
        dict[i] += 1
    except:
        pass
for i in arr2:
    sys.stdout.write(str(dict[i])+' ')


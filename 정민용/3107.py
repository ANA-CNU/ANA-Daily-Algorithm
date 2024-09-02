import sys

data = sys.stdin.readline().rstrip().split(':')
arr = []
index = -1
for i, d in enumerate(data):
    if not d:
        if index != -1:
            continue     
        else:
            index = i
    arr.append(d)

cnt = 8 - (len(arr) - 1)

res = []
for i, a in enumerate(arr):
    a = '0' * (4 - len(a)) + a
    if i == index:
        for _ in range(cnt):
            res.append(a)
    else:
        res.append(a)

print(':'.join(res))
N = int(input())

d = {}

for i in range(N):
    fileType = input().split(".")[1]
    if d.get(fileType):
        d[fileType] += 1
    else:
        d[fileType] = 1

sortedD = dict(sorted(d.items()))

for key, value in sortedD.items():
    print(key, value)
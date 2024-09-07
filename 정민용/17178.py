import sys

n = int(sys.stdin.readline().rstrip())
arr = [list(map(str, sys.stdin.readline().split())) for _ in range(n)]
data  = []
for i in range(n):
    data.append([])
    for j in range(5):
        b = arr[i][j].split('-')
        b[1] = '0' * (3-len(b[1])) + b[1]
        data[-1].append('-'.join(b))

sorted_arr = []
for i in range(n):
    for a in data[i]:
        sorted_arr.append(a)
sorted_arr.sort()

rest = []
index, line = 0, 0
line_index = 0
while line < n:
    while rest and rest[-1] == sorted_arr[index] and index < len(sorted_arr):
        rest.pop()
        index += 1

    if arr[line][line_index] == sorted_arr[index]:
        index += 1
    else:
        rest.append(data[line][line_index])

    while rest and rest[-1] == sorted_arr[index] and index < len(sorted_arr):
        rest.pop()
        index += 1
    
    line_index = (line_index + 1) % 5
    if line_index == 0:
        line += 1
        
if index == len(sorted_arr):
    print('GOOD')
else:
    print('BAD')
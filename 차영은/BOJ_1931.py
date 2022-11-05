import sys

n = int(sys.stdin.readline())
arr = []
ans_arr = []

for _ in range(n):
    a = tuple(map(int, sys.stdin.readline().split()))
    arr.append(a)

arr.sort(key=lambda x: (x[1], x[0]))
after = arr[0][1]

for i in arr:
    if i[0] >= after:
        ans_arr.append(i)
        after = i[1]

print(len(ans_arr) if ans_arr[0] == arr[0] else len(ans_arr) + 1)

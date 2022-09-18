import sys

n = int(sys.stdin.readline())
dic = {}
arr = []

for _ in range(n):
    num = int(sys.stdin.readline())

    if num in dic:
        dic[num] += 1
    else:
        dic[num] = 1

M = max(dic.values())

for i in dic:
    if M == dic[i]:
        arr.append(i)

arr.sort()
print(arr[0])

import sys

n = int(sys.stdin.readline())
dic = {}
arr = []

for _ in range(n):
    book = sys.stdin.readline().strip()

    if book in dic:
        dic[book] += 1
    else:
        dic[book] = 1

num = max(dic.values())

for i in dic:
    if num == dic[i]:
        arr.append(i)

arr.sort()
print(arr[0])

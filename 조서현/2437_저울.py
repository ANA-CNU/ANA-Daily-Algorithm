n = int(input())
arr = list(map(int, input().split()))
arr.sort()

s = 1
for e in arr:
    if s < e:
        break
    s += e
print(s)
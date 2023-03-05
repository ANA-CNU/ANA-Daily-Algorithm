# 실버 4 11652 카드

N = int(input())

d = {}

maxKey = 9
maxValue = 0

for i in range(N):
    num = int(input())
    if d.get(num):
        d[num] = d[num] + 1
    else:
        d[num] = 1

for key,value in d.items():
    if value > maxValue:
        maxValue = value
        maxKey = key
    elif value == maxValue:
        if key < maxKey:
            maxKey = key
            maxValue = value

print(maxKey)
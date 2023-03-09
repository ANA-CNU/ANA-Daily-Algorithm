n, m = map(int,input().split())

d = {}

answer = []

nums = list(map(int, input().split()))
for i in range(n):
    if d.get(nums[i]):
        d[nums[i]] += 1
    else:
        d[nums[i]] = 1

sorted = dict(sorted(d.items(), key=lambda item: item[1], reverse=True))

for key, value in sorted.items():
    for i in range(value):
        answer.append(key)
    
print(*answer)
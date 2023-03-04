# 실버 3 14425 문자열 집합

n, m = list(map(int, input().split()))
count = 0

d = {}

for i in range(n):
    d[input()] = 1

for i in range(m):
    if d.get(input()):
        count += 1

print(count)
round = int(input())

sum_chang = 100
sum_sang = 100

for i in range(round):
    c, s = map(int, input().split())
    if c > s:
        sum_sang -= c
    elif c < s:
        sum_chang -= s
    else:
        continue

print(sum_chang)
print(sum_sang)

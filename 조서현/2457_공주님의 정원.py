import sys

n = int(input())
flowers = []
for _ in range(n):
    m1, d1, m2, d2 = map(int, sys.stdin.readline().split())
    flowers.append(((m1, d1), (m2, d2)))
flowers.sort()
# print(flowers)

last = (3, 1)
cnt = 0
while flowers:
    if last > (11, 30) or flowers[0][0] > last:
        break
    new_last = (0, 0)
    for _ in range(len(flowers)):
        if flowers[0][0] <= last:
            if new_last <= flowers[0][1]:
                new_last = flowers[0][1]
            flowers.pop(0)
        else:
            break
    last = new_last
    cnt += 1
print(cnt if last > (11, 30) else 0)
import sys
n, m = map(int, sys.stdin.readline().split())

odd, even = [], []
cnt = [m]*n
while True:
    cls, name = sys.stdin.readline().split()
    cls = int(cls)
    if (cls, name) == (0, "0"):
        break

    if cnt[cls-1] == 0:
        continue
    
    if cls%2 == 0:
        even.append([cls, name])
    else:
        odd.append([cls, name])
    cnt[cls-1] -= 1

odd.sort(key=lambda x:(x[0], len(x[1]), x[1]))
even.sort(key=lambda x:(x[0], len(x[1]), x[1]))

for i in odd:
    print(i[0], i[1])
for i in even:
    print(i[0], i[1])

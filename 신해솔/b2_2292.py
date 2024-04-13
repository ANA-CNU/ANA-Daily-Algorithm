n = int(input())
line = 1
cnt = 1

while n > line:
    cnt += 1
    line += (cnt-1)*6

print(cnt)

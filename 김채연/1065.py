n = int(input())
cnt = 0
for i in range(1, n+1):
    p = list(map(int, list(str(i))))
    if len(p)<3:
        cnt +=1
    else:
        num = p[0]-p[1]
        cnt +=1
        for i in range(len(p)-1):
            if p[i]-p[i+1]!=num:
                cnt -=1
                break

print(cnt)

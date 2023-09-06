n, k = map(int, input().split())
coin = [0]*n
cnt = 0
for i in range(n):
    coin[i] = int(input())
for i in range(len(coin)-1, -1, -1):
    if k>=coin[i]:
        cnt = cnt+k//coin[i]
        k = k%coin[i]
    if k<=0:
        break
print(cnt)


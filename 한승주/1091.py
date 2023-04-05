n = int(input())
p = list(map(int, input().split()))
ori = p
s = list(map(int, input().split()))
g = [0, 1, 2] * (n // 3)
new = [0] * n
cnt = 0
 
while p != g:
    for i in range(n):
       new[s[i]] = p[i]
 
    p = new
    new = [0] * n
    cnt += 1
    if ori == p:
        cnt =- 1
        break
print(cnt)
N = int(input())
L = []
dp = []

for _ in range(N):
    L.append(int(input()))

dp.append (L[0])
if N>1:
    dp.append (L[0]+L[1])
if N>2:
    dp.append (max(L[0]+L[2], L[1]+L[2]))

for i in range(3, N):
    dp.append (max(dp[i-2]+L[i], dp[i-3]+L[i-1]+L[i]))

print (dp)
print (dp.pop())
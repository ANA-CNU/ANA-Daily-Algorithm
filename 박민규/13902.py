# 백준 13902번 개업2
# dp 쓰면 쉬운문제 
import sys
input = sys.stdin.readline
from itertools import combinations

n, m = map(int, input().split())

wok = list(map(int, input().split()))

# 웍의 사이즈에 따라 한 번에 요리할 수 있는 음식의 수
# 아 이건 시간초과...
# for i in range(m):
#     for j in range(i + 1, m):
#         wok.append(wok[i] + wok[j])

for i,j in combinations(wok,2):
    if i+j <= n:
        wok.append(i+j)

wok = list(set(wok))

# n 그릇을 만드는데 필요한 요리횟수
dp = [0 for i in range(n+1)]

for i in wok:
    # 어떻게든 요리 한 번은 하니까 최소비용 == 1
    dp[i] = 1
    for j in range(i+1,n+1):
        if dp[j-i] != 0 and (dp[j] == 0 or dp[j] > dp[j-i] + 1):
            dp[j] = dp[j-i] + 1

if dp[n] != 0:
    print(dp[n])
else:
    print(-1)

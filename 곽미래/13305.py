import sys
n = int(sys.stdin.readline())
road = list(map(int, sys.stdin.readline().split()))
price = list(map(int, sys.stdin.readline().split()))
total = 0
min_price = 1_000_000_000
for i in range(n-1):
    if min_price > price[i]:
        min_price = price[i]
    total += min_price*road[i]
print(total)
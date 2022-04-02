import copy
import sys
from itertools import permutations
input = __import__('sys').stdin.readline
if __name__ == "__main__":
    n = int(input())
    price = list(map(int, input().split()))
    price.insert(0, 0)

    discount = [[] for _ in range(n+1)]
    for i in range(1, n+1):
        discount_n = int(input())
        for j in range(discount_n):
            a, j = map(int, input().split())
            discount[i].append((a, j))

    min_price = sys.maxsize
    for c in permutations(range(1, n+1), n):
        temp_price = copy.deepcopy(price)
        ans = 0
        for i in c:
            ans += temp_price[i]
            for d in discount[i]:
                temp_price[d[0]] -= d[1]
                if temp_price[d[0]] < 1:
                    temp_price[d[0]] = 1
        min_price = min(min_price, ans)
    print(min_price)

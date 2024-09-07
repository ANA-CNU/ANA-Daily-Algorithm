import sys
import math

n, m = map(int, sys.stdin.readline().split())

res = 0

if n % m == 0:
    print(res)
else:
    if n > m:
        n %= m
    res = m - math.gcd(n, m)

    print(res)

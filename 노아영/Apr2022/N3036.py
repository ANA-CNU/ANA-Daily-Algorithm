from math import gcd
import sys
n = int(sys.stdin.readline())
r = list(map(int, sys.stdin.readline().split()))
for i in r[1:]:
    div = gcd(r[0], i)
    print(f'{r[0]//div}/{i//div}')
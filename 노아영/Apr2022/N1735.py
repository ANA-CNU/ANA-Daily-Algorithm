import sys
from math import lcm, gcd
a, aa = map(int, sys.stdin.readline().rstrip().split())
b, bb = map(int, sys.stdin.readline().rstrip().split())
d = lcm(aa, bb)
u = (d//aa)*a+(d//bb)*b
gcd_ = gcd(u, d)
print(u//gcd_, d//gcd_)
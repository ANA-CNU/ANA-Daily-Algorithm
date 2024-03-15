def gcd(a,b):
    min = a
    max = b
    if a>b:
        min = b
        max = a
    while max%min != 0:
        max %= min
        min, max = max, min
    return min
import sys
a,b = map(int,sys.stdin.readline().split())
c,d = map(int,sys.stdin.readline().split())
numerator = b*c+a*d
denominator = b*d
g_c_d = gcd(numerator, denominator)
print(numerator//g_c_d, denominator//g_c_d)






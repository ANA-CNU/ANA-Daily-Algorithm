# BOJ 24892
# Fraction 으로 사다리꼴 모양으로 쪼개서 계산

from math import *

class Fraction():
    def __init__(self, p, q):
        self.num = p
        self.den = q
        self.update()
        
    def update(self):
        t = gcd(self.num, self.den)
        if t == 1:
            return
        else:
            self.num = int(self.num / t)
            self.den = int(self.den / t)
            return
    
    def __add__(self, obj):
        x = self.num * obj.den + self.den * obj.num
        y = self.den * obj.den
        return Fraction(x, y)
    
    def __sub__(self, obj):
        obj.num *= (-1)
        return self.__add__(obj)
    
    def __mul__(self, obj):
        x = self.num * obj.num
        y = self.den * obj.den
        return Fraction(x, y)


def Area(n, a, b):
    c = b - a
    temp = Fraction(0, 1)
    for i in range(1, n):
        x = Fraction(i * c, n)
        y = Fraction((i + 1) * c, n)
        temp += x * y * (y - x)
    max_area = temp * Fraction(1, 2)
    return max_area.num, max_area.den
    
def inv(n):
    p=n; res=1; y=C-2
    while y:
        if y%2: res=res*p%C
        p=p*p%C
        y//=2
    return res

C=10**9+7
n=int(input())
a,b=map(int,input().split())
t=Area(n,a,b)
print(inv(t[1])*t[0]%C)

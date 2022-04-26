# gcd 소인수분해

def gcd(o,p):
    if p==0: return o
    return gcd(p,o%p)
a,b=map(int,input().split())
g=gcd(a,b)
b//=g
n=[]
for i in range(1,b+1):
    if i*i>b: break
    if b%i==0: n.append(i)
ans=10**9
m=M=0
for x in n:
    if gcd(x,b//x)!=1: continue
    if ans>x+b//x:
        m=x
        M=b//x
        ans=x+b//x
print(g*m,g*M)

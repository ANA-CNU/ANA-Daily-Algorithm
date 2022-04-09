# BOJ 24731
# a xor b = c
# b xor c = a
# c xor a = b
# C(n,2)/3

K=int(input())
C=1000003
def pow(n,r):
    p=n; res=1; y=r
    while y:
        if y%2: res=res*p%C
        p=p*p%C
        y//=2
    return res
tmp=pow(2,K)
print(((tmp-1)*(tmp-2)%C)*pow(6,C-2)%C)

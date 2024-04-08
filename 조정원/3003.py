import sys

k,q,l,b,n,p=map(int,sys.stdin.readline().split())
k_n,q_n,l_n,b_n,n_n,p_n=0,0,0,0,0,0

if k!=1:
    k_n=1-k
if q!=1:
    q_n=1-q
if l!=2:
    l_n=2-l
if b!=2:
    b_n=2-b
if n!=2:
    n_n=2-n
if p!=8:
    p_n=8-p

print(k_n,q_n,l_n,b_n,n_n,p_n)

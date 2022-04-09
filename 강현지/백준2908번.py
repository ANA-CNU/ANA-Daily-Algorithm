# -*- coding: utf-8 -*-
"""
Created on Sat Apr  9 09:14:06 2022

@author: guswl
"""

A, B = input().split()
C = list()
D = list()
for i in range(2,-1,-1):
    C.append(A[i])
    D.append(B[i])
    
A = int(''.join(C))
B = int(''.join(D))
if(A > B):
    print(A)
else:
    print(B)
    
#다른 풀이
A, B = input().split()
A = int(A[::-1])
B = int(B[::-1])

if A > B:
    print(A)
else:
    print(B)
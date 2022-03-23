# -*- coding: utf-8 -*-
"""
Created on Tue Mar 22 10:40:02 2022

@author: guswl
"""

N, X = map(int, input().split())
A = list(map(int,input().split()))
for i in range(N):
    if (A[i]<X):
        print(A[i], end = " ")

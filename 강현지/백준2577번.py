# -*- coding: utf-8 -*-
"""
Created on Mon Mar 28 09:52:55 2022

@author: guswl
"""

A = int(input())
B = int(input())
C = int(input())

K = str(A*B*C)
K = list(K)
K = list(map(int, K))

for i in range(10):
    print(K.count(i))

# -*- coding: utf-8 -*-
"""
Created on Wed Mar 30 10:16:58 2022

@author: guswl
"""

N = int(input())

for i in range(5):
    A = input()
    A = list(A)
    sum = 0
    c = 1
    for j in A:
        if(j=="O"):
            sum += c
            c += 1
        else:
            c = 1
    print(sum)
    


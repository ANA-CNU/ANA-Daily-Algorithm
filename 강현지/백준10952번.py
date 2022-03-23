# -*- coding: utf-8 -*-
"""
Created on Wed Mar 23 11:10:23 2022

@author: guswl
"""

A, B = map(int,input().split())
while A>0 and B>0:
    print(A+B)
    A,B = map(int, input().split())
    if A==0 and B==0:
        break
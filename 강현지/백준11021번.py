# -*- coding: utf-8 -*-
"""
Created on Mon Mar 21 15:56:46 2022

@author: guswl
"""
N = int(input())
for i in range(1,N+1):
    A, B = map(int, input().split())
    print("Case #"+str(i)+":", A+B)
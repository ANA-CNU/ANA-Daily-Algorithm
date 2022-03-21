# -*- coding: utf-8 -*-
"""
Created on Mon Mar 21 16:16:51 2022

@author: guswl
"""

T = int(input())
for i in range(1,T+1):
    A, B = map(int, input().split())
    print("Case #"+str(i)+":",A,"+",B, "=",(A+B))
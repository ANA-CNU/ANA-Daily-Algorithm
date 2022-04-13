# -*- coding: utf-8 -*-
"""
Created on Wed Apr 13 10:07:32 2022

@author: guswl
"""

A, B, C = map(int, input().split())

if (B>=C):
    print(-1)
else:
    print(int(A/(C-B)+1))

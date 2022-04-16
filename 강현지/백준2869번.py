# -*- coding: utf-8 -*-
"""
Created on Sat Apr 16 11:49:47 2022

@author: guswl
"""

A, B, V = map(int, input().split())

x = (V-B)/(A-B)
if x == int(x):
    print(int(x))
else:
    print(int(x) + 1)
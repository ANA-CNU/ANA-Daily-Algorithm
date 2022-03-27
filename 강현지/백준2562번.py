# -*- coding: utf-8 -*-
"""
Created on Sun Mar 27 13:50:52 2022

@author: guswl
"""

N = list()
for i in range(9):
    N.append(int(input()))
print(max(N))
print(N.index(max(N))+1)

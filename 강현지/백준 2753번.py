# -*- coding: utf-8 -*-
"""
Created on Mon Mar 14 08:36:38 2022

@author: guswl
"""
A = int(input())
if ((A%4 == 0 and A%100 != 0) or A%400 == 0):
    print(1)
else:
    print(0)



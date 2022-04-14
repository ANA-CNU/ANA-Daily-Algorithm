# -*- coding: utf-8 -*-
"""
Created on Thu Apr 14 19:58:28 2022

@author: guswl
"""

N = int(input())

count = 1
endValue = 1
d = 6
while (N > endValue):
    count += 1
    endValue += d
    d += 6

print(count)
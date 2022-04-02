# -*- coding: utf-8 -*-
"""
Created on Sat Apr  2 11:30:57 2022

@author: guswl
"""

def d(n):
    k = n
    for i in range(1,4):
        if (n//(10**i) == 0):
            break
        while (n // (10**i) > 0):
            k += (n // 10^i)
            k += (n % 10^i)
    return k

k=39 + (n//10) + (n % 10) + 
39//100
d(39)

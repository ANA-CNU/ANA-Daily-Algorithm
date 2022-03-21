# -*- coding: utf-8 -*-
"""
Created on Wed Mar 16 13:15:06 2022

@author: guswl
"""

H, M = map(int,input().split())

if (H >= 1):
    if M>=45:
        print(H, M-45)
    else:
        print(H-1, 60-(45-M))

elif H == 0:
    if M >= 45:
        print(H, M - 45)
    else:
        print(23, 60-(45-M))
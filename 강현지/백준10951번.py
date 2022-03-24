# -*- coding: utf-8 -*-
"""
Created on Thu Mar 24 10:10:15 2022

@author: guswl
"""

A,B=map(int, input().split())
while True:
    try:
        print(A+B)
        A,B=map(int, input().split())
    except:
        break
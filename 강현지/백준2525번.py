# -*- coding: utf-8 -*-
"""
Created on Thu Mar 17 09:00:09 2022

@author: guswl
"""

A, B = map(int, input().split())
C = int(input())

A += C//60
B += C%60

if B >=60:
    A+=1
    B-=60

if A >= 24:
    A-=24
    
print(A, B)
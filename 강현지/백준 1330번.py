# -*- coding: utf-8 -*-
"""
Created on Sat Mar 12 08:27:16 2022

@author: guswl
"""

A, B = map(int, input().split())

if A > B:
    print(">")
elif A < B:
    print("<")
elif A == B:
    print("==")
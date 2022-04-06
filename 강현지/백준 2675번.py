# -*- coding: utf-8 -*-
"""
Created on Wed Apr  6 12:38:20 2022

@author: guswl
"""

n = int(input())
for i in range(n):
    num, s = input().split()
    text = ''
    for i in s:
        text += int(num)*i
    print(text)
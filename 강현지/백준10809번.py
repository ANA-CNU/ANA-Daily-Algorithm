# -*- coding: utf-8 -*-
"""
Created on Tue Apr  5 10:44:34 2022

@author: guswl
"""

S = input()
listS = list(S)
alpha = list(range(97,123))

for i in alpha:
    print(S.find(chr(i)))
    

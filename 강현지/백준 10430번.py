# -*- coding: utf-8 -*-
"""
Created on Thu Mar 10 11:37:34 2022

@author: guswl
"""

A, B, C = map(int,input().split())
print((A+B)%C,((A%C)+(B%C))%C,(A*B)%C,((A%C)*(B%C))%C,sep = "\n")

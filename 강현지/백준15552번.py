# -*- coding: utf-8 -*-
"""
Created on Mon Mar 21 09:16:24 2022

@author: guswl
"""
import sys
T = int(input())
for i in range(T):
    A,B = map(int, sys.stdin.readline().split())
    print(A+B)

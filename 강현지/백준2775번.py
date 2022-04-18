# -*- coding: utf-8 -*-
"""
Created on Mon Apr 18 20:01:57 2022

@author: guswl
"""

T = int(input())
for i in range(T):
    floor = int(input())
    num = int(input())
    list = []
    for i in range(1,num+1):
        list.append(i)
    for j in range(floor):
        for i in range(1,num):
            list[i] += list[i-1]
    print(list[-1])
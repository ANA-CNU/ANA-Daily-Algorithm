# -*- coding: utf-8 -*-
"""
Created on Tue Mar 29 23:39:44 2022

@author: guswl
"""

N = int(input())
List = list(map(int,input().split()))
M = max(List)
for i in range(N) :
    List[i] = List[i]/M*100

sum = 0
for i in range(N) :
    sum += List[i]

print(sum/N)
sum(List)

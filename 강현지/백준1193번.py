# -*- coding: utf-8 -*-
"""
Created on Fri Apr 15 10:25:09 2022

@author: guswl
"""

input_num = int(input())

line = 0 
max_num = 0
while input_num > max_num:
    line += 1  
    max_num += line  

gap = max_num - input_num 
if line % 2 == 0:
    r = line - gap
    c = gap + 1
else :
    r = gap + 1
    c = line - gap  
print(r,c, sep = "/")
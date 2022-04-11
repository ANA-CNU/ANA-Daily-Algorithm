# -*- coding: utf-8 -*-
"""
Created on Mon Apr 11 11:08:08 2022

@author: guswl
"""

croatia = ['c=', 'c-', 'dz=', 'd-', 'lj', 'nj', 's=', 'z=']
word = input()

for i in croatia:
    word = word.replace(i, "*")
print(len(word))
# -*- coding: utf-8 -*-
"""
Created on Tue Apr 12 10:31:26 2022

@author: guswl
"""

N = int(input())

for i in range(N):
    word = input()
    error = 0
    for i in range(0,len(word)-1):
        if (word[i] != word[i+1]):
            if (word[i] in word[i+1:]):
                N -= 1
                break
print(N)        

# -*- coding: utf-8 -*-
"""
Created on Sun Apr 10 08:10:55 2022

@author: guswl
"""

alphaNum = list()
k = 3
for i in range(2, 7):
    for j in range(3):
            alphaNum.append(k)
    k += 1
for i in range(4):
    alphaNum.append(k)
k += 1
for i in range(3):
    alphaNum.append(k)
k += 1
for i in range(4):
    alphaNum.append(k)
    
wordNum = list(input())
sum = 0
for i in wordNum:
    for j in range(len(alphaNum)):
       if((ord(i)-65) == j):
          sum +=alphaNum[j]
print(sum)

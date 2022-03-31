# -*- coding: utf-8 -*-
"""
Created on Thu Mar 31 09:46:27 2022

@author: guswl
"""

N = int(input())
for i in range(N):
    A = list(map(int,input().split()))
    count = 0
    avg = sum(A[1:])/A[0]
    for j in range(1,len(A)):
        if (A[j] > avg):
            count +=1
    prob = format((count/A[0])*100,".3f")
    print(str(prob)+"%")


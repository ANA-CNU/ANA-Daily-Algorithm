# -*- coding: utf-8 -*-
"""
Created on Sun Apr  3 00:23:08 2022

@author: guswl
"""

N = int(input())
count = 0
i=1
for i in range(1,N+1):
    k = list(map(int,str(i)))
    if(i<=99):
        count+=1
    elif ((k[2]-k[1])==(k[1]-k[0])):
        count+=1
        
print(count)
            
            


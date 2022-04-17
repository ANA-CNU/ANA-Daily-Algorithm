# -*- coding: utf-8 -*-
"""
Created on Sun Apr 17 11:07:39 2022

@author: guswl
"""

T = int(input())
for i in range(T):
    H, W, N = map(int,input().split())
    floor = N % H
    roomNum = (N // H) + 1
    if(floor == 0):
        floor = H
        roomNum -= 1
    print(int(floor*100+roomNum))
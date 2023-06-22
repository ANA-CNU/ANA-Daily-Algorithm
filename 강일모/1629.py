import sys

A, B, C = map(int, input().split())

def remainder(A, B, C):
    if (B == 0):
        return 1
    
    if (B == 1):
        return (A%C)
    
    if not(B % 2):
        return (remainder(A, B//2, C) ** 2) % C
    
    else:
        return (remainder(A, (B+1)//2, C) * remainder(A, B//2, C)) % C

print(remainder(A,B,C))
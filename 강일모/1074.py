import sys

def baseCaseSolution(r, c):
    if r == 0:
        if c == 0:
            return 1
        else:
            return 2
    else:
        if c == 0:
            return 3
        else:
            return 4
        
def divideAndConquer(n, r, c):
    if n == 2:
        return baseCaseSolution(r, c)
    
    else:
        sizeOfOneSide = n

        if (0 <= r < (sizeOfOneSide // 2)):
            if (0 <= c < (sizeOfOneSide // 2)):
                return divideAndConquer(n//2, r, c) + 0 * ((sizeOfOneSide // 2) ** 2)
            
            else:
                return divideAndConquer(n//2, r, c - (sizeOfOneSide // 2)) + 1 * ((sizeOfOneSide // 2) ** 2)

        else:
            if (0 <= c < (sizeOfOneSide // 2)):
                return divideAndConquer(n//2, r - (sizeOfOneSide // 2), c) + 2 * ((sizeOfOneSide // 2) ** 2)
                
            else:
                return divideAndConquer(n//2, r - (sizeOfOneSide // 2), c - (sizeOfOneSide // 2)) + 3 * ((sizeOfOneSide // 2) ** 2)

N, r, c = map(int, sys.stdin.readline().split())

print(divideAndConquer(2**N, r, c)-1)
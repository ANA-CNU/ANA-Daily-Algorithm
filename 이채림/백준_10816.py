import sys
from collections import Counter

if __name__ == '__main__':
    N = int(sys.stdin.readline().rstrip())
    nList = list(map(int, sys.stdin.readline().rstrip().split(' ')))
    nList.sort()

    M = int(sys.stdin.readline().rstrip())
    mList = list(map(int, sys.stdin.readline().rstrip().split(' ')))

    result = [0] * M

    count = Counter(nList)

    for i in range(M):
        low = 0
        high = N-1
        target = mList[i]
        while low <= high:
            middle = (low + high) // 2
            if nList[middle] < target:
                low = middle + 1
            elif nList[middle] > target:
                high = middle - 1
            else:
                result[i] = count[mList[i]]
                break
            
    for i in result:
        print(i, end=" ")


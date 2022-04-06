import sys

if __name__ == '__main__':
    N,M = map(int, sys.stdin.readline().rstrip().split(" "))
    trees = list(map(int, sys.stdin.readline().rstrip().split(" ")))
    
    low = 0
    high = max(trees)
    while low <= high:
        length = 0
        middle = (low + high) // 2
        for tree in trees:
            if middle <= tree:
                length += tree - middle
        if length >= M:
            low = middle + 1
        else:
            high = middle - 1

    print(high)



    
import sys

if __name__ == '__main__':
    arr = list(map(int, sys.stdin.readline().rstrip().split(" ")))

    if arr == sorted(arr):
        print("ascending")
    elif arr == sorted(arr, reverse=True):
        print("descending")
    else:
        print("mixed") 
        
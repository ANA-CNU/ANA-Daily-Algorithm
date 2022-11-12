import sys

n, m = map(int, sys.stdin.readline().split())
arr1 = list(map(int, sys.stdin.readline().split()))
arr2 = list(map(int, sys.stdin.readline().split()))
arr3 = arr1 + arr2
arr3.sort()

print(*arr3)

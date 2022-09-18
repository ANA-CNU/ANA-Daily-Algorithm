import sys

n, k = map(int, sys.stdin.readline().split())
arr = list(map(int, sys.stdin.readline().strip().split()))

arr.sort()

print(arr[k - 1])

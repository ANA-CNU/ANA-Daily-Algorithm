def gcd(a,b):
    max = a
    min = b
    if max < min :
        max, min = min, max
    while max % min != 0:
        temp = max
        max = min
        min = temp%max
    return min
import sys
n = int(sys.stdin.readline())
arr1 = []
for i in range(n):
    arr1.append(int(sys.stdin.readline()))
arr2 =[]
for i in range(n-1):
    arr2.append(arr1[i+1]-arr1[i])
g_c_d = arr2[0]
for i in range(n-2):
    g_c_d = gcd(g_c_d,arr2[i+1])
print(((arr1[n-1]-arr1[0])//g_c_d)-len(arr1)+1)


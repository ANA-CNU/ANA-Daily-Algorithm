#파도반수열
import sys
T = int(sys.stdin.readline())
arr = []
max = 0
for i in range(T):
    n = int(sys.stdin.readline())
    arr.append(n)
    if n > max:
        max = n

pado =[1,1,1,2,2]+ [0]*(max-5)
for i in range(max-5):
    pado[i+5] = pado[i]+pado[i+4]

for i in range(T):
    print(pado[arr[i]-1])

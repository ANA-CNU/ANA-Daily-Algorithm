T= int(input())
for i in range(T):
    k=int(input())
    n=int(input())
    d=[j for j in range(1,n+1)]

    for l in range(k):
        for jj in range(1,n):
            d[jj]=d[jj]+d[jj-1]
    print(d[n-1])
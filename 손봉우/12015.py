N = int(input())
L = list(map(int, input().split()))
T = [0]

for i in L:
    if T[-1] < i:
        T.append(i)
    else:
        start = 0
        end = len(T)-1

        while start <= end:
            mid = (start+end)//2

            if T[mid] < i:
                start = mid+1
            else:
                end = mid-1
        T[start] = i
print (len(T)-1)

N = int(input())
A = [i for i in range(N+1)]
A[1] = 1

for i in range(2, N+1) :
    A[i] = A[i-1] + A[i-2]
    
print(A[-1])